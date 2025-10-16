package com.poojaps.mindfulwork.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.poojaps.mindfulwork.R
import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase
import com.poojaps.mindfulwork.viewmodel.StatsViewModel
import java.text.DecimalFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import kotlin.math.max

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StatsScreen(
    viewModel: StatsViewModel = hiltViewModel()
) {
    val stats by viewModel.weeklyStats.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadWeeklyStats(System.currentTimeMillis())
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(R.string.weekly_summary_title),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        if (stats.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    stringResource(R.string.no_focus_data_yet),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                FocusSummaryCard(stats)
                FocusBarChart(stats)
                MoodTrendRow(stats)
            }
        }
    }
}

@Composable
private fun FocusSummaryCard(stats: List<GetWeeklyStatsUseCase.DailyStat>) {
    val totalFocus = stats.sumOf { it.totalFocusSeconds }
    val totalHours = totalFocus / 3600
    val totalMinutes = (totalFocus % 3600) / 60

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(stringResource(R.string.total_focus_time_label), style = MaterialTheme.typography.titleMedium)
            Text(
                stringResource(
                    R.string.focus_duration_hours_minutes,
                    totalHours,
                    DecimalFormat("00").format(totalMinutes)
                ),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                stringResource(R.string.compared_last_week_label, "+8%"),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun FocusBarChart(stats: List<GetWeeklyStatsUseCase.DailyStat>) {
    val orderedWeek = listOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    )

    val statsByDay = orderedWeek.map { day ->
        stats.find { LocalDate.parse(it.day).dayOfWeek == day }
    }
    val primaryColor = MaterialTheme.colorScheme.primary
    val tertiaryColor = MaterialTheme.colorScheme.tertiary

    val maxHours = max(1, stats.maxOfOrNull { it.totalFocusSeconds / 3600 } ?: 1)

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(stringResource(R.string.focus_duration_chart_label), style = MaterialTheme.typography.titleMedium)

            val animatedHeights = statsByDay.map { stat ->
                val target = if (stat == null || stat.totalFocusSeconds == 0) 0f
                else (stat.totalFocusSeconds / 3600f) / maxHours.toFloat()
                animateFloatAsState(
                    targetValue = target,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ).value
            }

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                val widthPerBar = (maxWidth / 14)

                Canvas(modifier = Modifier.fillMaxSize()) {
                    val barAreaHeight = size.height * 0.75f
                    val bottomY = size.height * 0.9f

                    statsByDay.forEachIndexed { index, stat ->
                        if (stat != null && stat.totalFocusSeconds > 0) {
                            val barHeight = animatedHeights[index] * barAreaHeight
                            val barX = (index * 2 + 1) * (widthPerBar.toPx() / 1.2f)
                            val gradient = Brush.verticalGradient(
                                colors = listOf(primaryColor, tertiaryColor)
                            )

                            drawRoundRect(
                                brush = gradient,
                                topLeft = Offset(barX, bottomY - barHeight),
                                size = androidx.compose.ui.geometry.Size(
                                    widthPerBar.toPx(),
                                    barHeight
                                ),
                                cornerRadius = CornerRadius(16f, 16f)
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                orderedWeek.forEach { day ->
                    val label = day.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                    Text(
                        label.uppercase(Locale.getDefault()),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun MoodTrendRow(stats: List<GetWeeklyStatsUseCase.DailyStat>) {
    val orderedWeek = listOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    )

    val statsByDay = orderedWeek.map { day -> stats.find { LocalDate.parse(it.day).dayOfWeek == day } }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(stringResource(R.string.mood_trend_title), style = MaterialTheme.typography.titleMedium)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                statsByDay.forEachIndexed { index, stat ->
                    val emoji = when (stat?.dominantMood) {
                        stringResource(R.string.happy) -> "😊"
                        stringResource(R.string.neutral) -> "😐"
                        stringResource(R.string.sad) -> "😔"
                        stringResource(R.string.angry) -> "😡"
                        else -> "🙂"
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AnimatedVisibility(visible = true) {
                            Text(emoji, style = MaterialTheme.typography.headlineLarge)
                        }
                        Text(
                            orderedWeek[index].getDisplayName(TextStyle.SHORT, Locale.getDefault())
                                .uppercase(Locale.getDefault()),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}
