package com.poojaps.mindfulwork.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.max

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FocusBarChart(stats: List<GetWeeklyStatsUseCase.DailyStat>) {
    val maxHours = max(1, stats.maxOf { it.totalFocusSeconds / 3600 })
    val dateFormatter = DateTimeFormatter.ofPattern("EEE")

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Focus Duration (hrs/day)", style = MaterialTheme.typography.titleMedium)

            val animatedHeights = stats.map { dayStat ->
                val targetHeight = (dayStat.totalFocusSeconds / 3600f) / maxHours.toFloat()
                animateFloatAsState(
                    targetValue = targetHeight,
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = EaseInOutCubic
                    ), label = ""
                ).value
            }
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                val barWidth = size.width / (stats.size * 2)

                stats.forEachIndexed { index, _ ->
                    val barHeight = animatedHeights[index] * size.height
                    val x = (index * 2 + 1) * barWidth
                    val y = size.height - barHeight

                    drawLine(
                        color = Color.White,
                        start = Offset(x, size.height),
                        end = Offset(x, y),
                        strokeWidth = barWidth,
                        cap = StrokeCap.Round
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                stats.forEach {
                    val date = LocalDate.parse(it.day)
                    Text(
                        text = date.format(dateFormatter),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}
