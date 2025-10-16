package com.poojaps.mindfulwork.ui.screens

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.poojaps.mindfulwork.R
import com.poojaps.mindfulwork.service.FocusTimerActions
import com.poojaps.mindfulwork.service.FocusTimerService
import com.poojaps.mindfulwork.ui.components.CelebrationConfetti
import com.poojaps.mindfulwork.viewmodel.FocusTimerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FocusTimerScreen(
    viewModel: FocusTimerViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val summary by viewModel.todaySummary.collectAsState()
    val timeLeft by viewModel.timeLeft.collectAsState()
    val totalTime by viewModel.totalTime.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var showConfetti by remember { mutableStateOf(false) }

    // Show confetti when session fully completed
    LaunchedEffect(timeLeft, isRunning) {
        if (!isRunning && totalTime > 0 && timeLeft == 0) {
            showConfetti = true
            viewModel.refreshTodaySummary()
            scope.launch {
                snackbarHostState.showSnackbar("🎯 Focus session completed: ${totalTime / 60}m")
            }
            delay(6000)
            showConfetti = false
        }
    }

    val durations = listOf(1, 25, 45, 60)
    var selectedDuration by remember { mutableIntStateOf(25) }

    val isPaused = !isRunning && timeLeft > 0
    val displayTime = if (isRunning || timeLeft > 0) timeLeft else selectedDuration * 60
    val displayTotal = if (isRunning || totalTime > 0) totalTime else selectedDuration * 60

    val progress by animateFloatAsState(
        targetValue = if (displayTotal > 0) displayTime.toFloat() / displayTotal.toFloat() else 0f,
        animationSpec = tween(500, easing = LinearEasing),
        label = "progressAnim"
    )

    val progressColor by animateColorAsState(
        targetValue = when {
            progress > 0.6f -> MaterialTheme.colorScheme.primary
            progress > 0.3f -> MaterialTheme.colorScheme.tertiary
            else -> MaterialTheme.colorScheme.error
        },
        animationSpec = tween(600),
        label = "colorAnim"
    )

    // Listen to service updates
    DisposableEffect(Unit) {
        val receiver = LocalBroadcastManager.getInstance(context)
        val filter = IntentFilter(FocusTimerActions.ACTION_UPDATE)
        val updateReceiver = object : BroadcastReceiver() {
            override fun onReceive(c: Context?, intent: Intent?) {
                val total = intent?.getIntExtra(FocusTimerActions.EXTRA_TOTAL_TIME, 0) ?: 0
                val left = intent?.getIntExtra(FocusTimerActions.EXTRA_TIME_LEFT, 0) ?: 0
                val running = intent?.getBooleanExtra(FocusTimerActions.EXTRA_IS_RUNNING, false) ?: false
                viewModel.updateState(total, left, running)
            }
        }
        receiver.registerReceiver(updateReceiver, filter)
        onDispose { receiver.unregisterReceiver(updateReceiver) }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.focus_timer_title), style = MaterialTheme.typography.titleLarge) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        progress = { progress },
                        modifier = Modifier.size(220.dp),
                        color = progressColor,
                        strokeWidth = 12.dp,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                        strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val minutes = displayTime / 60
                        val seconds = displayTime % 60
                        Text(
                            "%02d:%02d".format(minutes, seconds),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            when {
                                isRunning -> stringResource(R.string.focus_state_running)
                                isPaused -> stringResource(R.string.focus_state_paused)
                                else -> stringResource(R.string.focus_state_ready)
                            },
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    // Confetti overlay
                    CelebrationConfetti(
                        visible = showConfetti,
                        modifier = Modifier
                            .matchParentSize()
                            .align(Alignment.Center)
                    )
                }
            }

            // Duration selection chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                durations.forEach { duration ->
                    FilterChip(
                        selected = selectedDuration == duration,
                        enabled = !isRunning && !isPaused,
                        onClick = { selectedDuration = duration },
                        label = { Text(stringResource(R.string.focus_duration_label, duration)) }
                    )
                }
            }

            // Start / Pause / Resume button
            FilledTonalButton(
                onClick = {
                    val intent = Intent(context, FocusTimerService::class.java).apply {
                        action = when {
                            !isRunning && timeLeft == 0 -> FocusTimerActions.ACTION_START
                            isRunning -> FocusTimerActions.ACTION_PAUSE
                            else -> FocusTimerActions.ACTION_RESUME
                        }
                        putExtra(FocusTimerActions.EXTRA_TOTAL_TIME, selectedDuration * 60)
                    }
                    context.startForegroundService(intent)
                },
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth(0.65f)
            ) {
                when {
                    !isRunning && timeLeft == 0 -> {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(stringResource(R.string.focus_action_start))
                    }
                    isRunning -> {
                        Icon(Icons.Filled.Pause, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(stringResource(R.string.focus_action_pause))
                    }
                    else -> {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(stringResource(R.string.focus_action_resume))
                    }
                }
            }

            // End button
            OutlinedButton(
                onClick = {
                    val focusedSeconds = totalTime - timeLeft
                    val intent = Intent(context, FocusTimerService::class.java).apply {
                        action = FocusTimerActions.ACTION_END
                    }
                    context.startForegroundService(intent)
                    viewModel.updateState(total = 0, left = 0, running = false)
                    viewModel.refreshTodaySummary()

                    val minutesCompleted = focusedSeconds / 60
                    scope.launch {
                        snackbarHostState.showSnackbar("⏱ Focused for $minutesCompleted minutes")
                    }
                },
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth(0.65f),
                enabled = (timeLeft > 0 || isRunning)
            ) {
                Icon(Icons.Filled.Stop, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(stringResource(R.string.focus_action_end))
            }

            // Summary cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StatCard(stringResource(R.string.focus_stat_sessions), summary.sessionsCount.toString(), Modifier.weight(1f))
                StatCard(stringResource(R.string.focus_stat_total_focus), formatDuration(summary.totalSeconds), Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun StatCard(title: String, value: String, modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier, shape = MaterialTheme.shapes.large) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(title, style = MaterialTheme.typography.labelMedium)
            Text(value, style = MaterialTheme.typography.titleLarge)
        }
    }
}

private fun formatDuration(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    return if (hours > 0) "${hours}h ${minutes}m" else "${minutes}m"
}
