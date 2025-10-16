package com.poojaps.mindfulwork.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.poojaps.mindfulwork.R
import com.poojaps.mindfulwork.ui.components.QuoteCard
import com.poojaps.mindfulwork.viewmodel.HomeViewModel
import com.poojaps.mindfulwork.viewmodel.MoodViewModel
import com.poojaps.mindfulwork.viewmodel.SettingsViewModel
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDashboardScreen(
    onSettingsClick: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
    moodViewModel: MoodViewModel = hiltViewModel(),
    settingsViewModel: SettingsViewModel = hiltViewModel()
) {
    val summary by homeViewModel.homeSummary.collectAsStateWithLifecycle()
    val quote by homeViewModel.quote.collectAsStateWithLifecycle()
    val settings by settingsViewModel.settings.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) { homeViewModel.loadHome(System.currentTimeMillis()) }

    val today = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()) }
    LaunchedEffect(today) { moodViewModel.loadMoodsForDate(today) }

    val moods by moodViewModel.moodsForDate.collectAsState()
    val dominantMood = remember(moods) {
        moods.groupingBy { it.label }.eachCount().maxByOrNull { it.value }?.key
    }
    val dominantEmoji = when (dominantMood) {
        "Happy" -> "😊"
        "Neutral" -> "😐"
        "Sad" -> "😔"
        "Angry" -> "😡"
        else -> "🙂"
    }
    val displayName = settings.displayName?.takeIf { it.isNotBlank() } ?: stringResource(R.string.friend_default)

    val visibleStates = remember { MutableTransitionState(false) }
    LaunchedEffect(Unit) {
        delay(150)
        visibleStates.targetState = true
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = stringResource(R.string.settings_content_description),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        AnimatedVisibility(
            visibleState = visibleStates,
            enter = fadeIn(animationSpec = tween(800, easing = EaseInOutCubic)),
            exit = fadeOut(animationSpec = tween(400, easing = EaseInOutCubic))
        ) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(20.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                Text(
                    text = stringResource(R.string.greeting_text, displayName),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )

                AnimatedItem(index = 0) {
                    Text(
                        text = when (dominantMood) {
                            "Happy" -> stringResource(R.string.mood_happy)
                            "Neutral" -> stringResource(R.string.mood_neutral)
                            "Sad" -> stringResource(R.string.mood_sad)
                            "Angry" -> stringResource(R.string.mood_angry)
                            else -> stringResource(R.string.mood_default)
                        },
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                AnimatedItem(index = 1) {
                    quote?.let { QuoteCard(it.text, it.author) }
                }

                AnimatedItem(index = 2) {
                    DashboardSummary(summary, dominantEmoji, dominantMood)
                }

                AnimatedItem(index = 3) {
                    Text(
                        text = stringResource(R.string.footer_message, displayName),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
private fun AnimatedItem(
    index: Int,
    delayPerItem: Int = 340,
    content: @Composable () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(index * delayPerItem.toLong())
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(650, easing = EaseInOutCubic)) +
                scaleIn(initialScale = 0.9f, animationSpec = tween(650, easing = EaseInOutCubic)) +
                slideInVertically(initialOffsetY = { it / 6 }, animationSpec = tween(650, easing = EaseInOutCubic)),
        exit = fadeOut(animationSpec = tween(400))
    ) {
        Box(modifier = Modifier.fillMaxWidth().scale(1f)) {
            content()
        }
    }
}

@Composable
fun DashboardSummary(
    summary: com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase.HomeSummary?,
    dominantEmoji: String,
    dominantMood: String?,
    modifier: Modifier = Modifier
) {
    if (summary == null) return
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardCard(
                title = stringResource(R.string.focus_title),
                subtitle = stringResource(R.string.focus_subtitle),
                value = formatDuration(summary.totalFocusSeconds),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                modifier = Modifier.weight(1f)
            )
            DashboardCard(
                title = stringResource(R.string.mood_title),
                subtitle = stringResource(R.string.mood_subtitle),
                value = if (dominantMood != null) "$dominantEmoji $dominantMood"
                else stringResource(R.string.mood_not_logged),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                modifier = Modifier.weight(1f)
            )
        }

        DashboardCard(
            title = stringResource(R.string.streak_title),
            subtitle = stringResource(R.string.streak_subtitle),
            value = "${summary.streak} ${stringResource(R.string.days)}",
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun DashboardCard(
    title: String,
    subtitle: String,
    value: String,
    containerColor: Color,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(containerColor = containerColor),
        shape = MaterialTheme.shapes.extraLarge,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleSmall)
            Text(subtitle, style = MaterialTheme.typography.labelSmall)
            Text(value, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

private fun formatDuration(totalSeconds: Int): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    return when {
        hours > 0 -> "${hours}h ${minutes}m"
        else -> "${minutes}m"
    }
}
