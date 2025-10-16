package com.poojaps.mindfulwork.domain.usecase.home

import android.os.Build
import androidx.annotation.RequiresApi
import com.poojaps.mindfulwork.data.repository.FocusRepository
import com.poojaps.mindfulwork.data.repository.MoodRepository
import com.poojaps.mindfulwork.data.repository.QuoteRepository
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

class GetHomeSummaryUseCase @Inject constructor(
    private val focusRepo: FocusRepository,
    private val moodRepo: MoodRepository,
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(epochMs: Long): HomeSummary {
        val zone = ZoneId.systemDefault()
        val sessions = focusRepo.getSessionsForDay(epochMs, zone)
        val moods = moodRepo.getMoodsForDate(
            Instant.ofEpochMilli(epochMs).atZone(zone).toLocalDate().toString()
        )

        val totalFocus = sessions.sumOf { it.durationSec }
        val todayMood = moods.lastOrNull()?.label
        val streak = computeStreak(sessions)

        return HomeSummary(
            totalFocusSeconds = totalFocus,
            todayMood = todayMood,
            streak = streak
        )
    }

    private fun computeStreak(sessions: List<Any>): Int {
        // basic streak: 1 if today has sessions, else 0
        return if (sessions.isNotEmpty()) 1 else 0
    }

    data class HomeSummary(
        val totalFocusSeconds: Int,
        val todayMood: String?,
        val streak: Int
    )
}
