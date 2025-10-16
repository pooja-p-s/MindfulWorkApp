package com.poojaps.mindfulwork.ui.screens

import android.text.format.DateUtils
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.poojaps.mindfulwork.R
import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.viewmodel.MoodViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodTrackerScreen(
    viewModel: MoodViewModel = hiltViewModel()
) {
    val moods by viewModel.moodsForDate.collectAsState()
    val today = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()) }

    var selectedEmoji by remember { mutableStateOf("😊") }
    val defaultLabel = stringResource(R.string.happy)
    var label by remember { mutableStateOf(defaultLabel) }

    LaunchedEffect(today) {
        viewModel.loadMoodsForDate(today)
    }

    val moodCounts = moods.groupingBy { it.label }.eachCount()
    val totalMoods = moodCounts.values.sum().coerceAtLeast(1)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.mood_tracker_title), style = MaterialTheme.typography.titleLarge) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (moods.isNotEmpty()) {
                DominantMoodCard(moods)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    "😊" to stringResource(R.string.happy),
                    "😐" to stringResource(R.string.neutral),
                    "😔" to stringResource(R.string.sad),
                    "😡" to stringResource(R.string.angry)
                ).forEach { (emoji, name) ->
                    FilterChip(
                        selected = selectedEmoji == emoji,
                        onClick = {
                            selectedEmoji = emoji
                            label = name
                        },
                        label = { Text(emoji) }
                    )
                }
            }

            Button(
                onClick = {
                    viewModel.logMood(
                        moodDate = today,
                        moodTs = System.currentTimeMillis(),
                        emoji = selectedEmoji,
                        label = label
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Mood, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(stringResource(R.string.log_mood_button))
            }

            if (moods.isNotEmpty()) {
                MoodDistributionCard(moodCounts, totalMoods)
                LatestLogsCard(moods)
            }
        }
    }
}

@Composable
private fun DominantMoodCard(moods: List<MoodEntity>) {
    val moodCounts = moods.groupingBy { it.label }.eachCount()
    val dominant = moodCounts.maxByOrNull { it.value }?.key ?: stringResource(R.string.none)
    val emoji = when (dominant) {
        stringResource(R.string.happy) -> "😊"
        stringResource(R.string.neutral) -> "😐"
        stringResource(R.string.sad) -> "😔"
        stringResource(R.string.angry) -> "😡"
        else -> "🙂"
    }

    ElevatedCard(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(stringResource(R.string.dominant_mood_label), style = MaterialTheme.typography.labelMedium)
                Text(dominant, style = MaterialTheme.typography.titleLarge)
//                Text(
//                    stringResource(R.string.logged_times, moods.size),
//                    style = MaterialTheme.typography.bodySmall
//                )
            }
            Text(text = emoji, style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Composable
private fun MoodDistributionCard(moodCounts: Map<String, Int>, totalMoods: Int) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(stringResource(R.string.mood_distribution_title), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))

            moodCounts.entries.forEach { entry ->
                val percent = (entry.value * 100f) / totalMoods
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        stringResource(R.string.mood_distribution_item, entry.key, entry.value),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text("${percent.toInt()}%", style = MaterialTheme.typography.bodySmall)
                }
                LinearProgressIndicator(
                    progress = { percent / 100f },
                    color = when (entry.key) {
                        stringResource(R.string.happy) -> MaterialTheme.colorScheme.primary
                        stringResource(R.string.neutral) -> MaterialTheme.colorScheme.tertiary
                        stringResource(R.string.sad) -> MaterialTheme.colorScheme.error
                        stringResource(R.string.angry) -> MaterialTheme.colorScheme.secondary
                        else -> MaterialTheme.colorScheme.outline
                    },
                    modifier = Modifier.fillMaxWidth().height(8.dp)
                )
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun LatestLogsCard(moods: List<MoodEntity>) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(stringResource(R.string.latest_logs_title), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))

            val latestPerMood = moods
                .groupBy { it.label }
                .mapValues { it.value.maxByOrNull { mood -> mood.moodTs } }

            latestPerMood.forEach { (label, mood) ->
                if (mood != null) {
                    val relativeTime = DateUtils.getRelativeTimeSpanString(
                        mood.moodTs,
                        System.currentTimeMillis(),
                        DateUtils.MINUTE_IN_MILLIS
                    ).toString()

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("${mood.emoji} $label", style = MaterialTheme.typography.bodyMedium)
                        Text(relativeTime, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}
