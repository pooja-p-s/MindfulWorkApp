package com.poojaps.mindfulwork.domain.usecase.stats

import android.os.Build
import androidx.annotation.RequiresApi
import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.data.repository.FocusRepository
import com.poojaps.mindfulwork.data.repository.MoodRepository
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

class GetWeeklyStatsUseCase @Inject constructor(
    private val focusRepo: FocusRepository,
    private val moodRepo: MoodRepository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(todayEpochMs: Long): List<DailyStat> {
        val zone = ZoneId.systemDefault()
        val today = LocalDate.ofEpochDay(todayEpochMs / 86_400_000) // approx conversion

        val from = today.minusDays(6).atStartOfDay(zone).toInstant().toEpochMilli()
        val to = today.plusDays(1).atStartOfDay(zone).toInstant().toEpochMilli()

        val sessions = focusRepo.getWeeklySessions(from, to)
        val moods = moodRepo.getMoodsBetween(
            fromDate = today.minusDays(6).toString(),
            toDate = today.toString()
        )

        return (0..6).map { i ->
            val day = today.minusDays((6 - i).toLong())
            val dayStart = day.atStartOfDay(zone).toInstant().toEpochMilli()
            val dayEnd = day.plusDays(1).atStartOfDay(zone).toInstant().toEpochMilli()

            val daySessions = sessions.filter { it.startTs in dayStart until dayEnd }
            val totalSec = daySessions.sumOf { it.durationSec }

            val dayMoods = moods.filter { it.moodDate == day.toString() }
            val dominantMood = findDominantMood(dayMoods)

            DailyStat(
                day = day.toString(),
                totalFocusSeconds = totalSec,
                dominantMood = dominantMood
            )
        }
    }

    private fun findDominantMood(moods: List<MoodEntity>): String? {
        return moods.groupingBy { it.label }.eachCount().maxByOrNull { it.value }?.key
    }

    data class DailyStat(
        val day: String,
        val totalFocusSeconds: Int,
        val dominantMood: String?
    )
}
