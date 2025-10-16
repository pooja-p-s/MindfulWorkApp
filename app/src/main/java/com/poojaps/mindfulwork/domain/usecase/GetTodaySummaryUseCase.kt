package com.poojaps.mindfulwork.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.poojaps.mindfulwork.data.repository.FocusRepository
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

class GetTodaySummaryUseCase @Inject constructor(
    private val repo: FocusRepository
) {
    data class TodaySummary(
        val totalSeconds: Int,
        val sessionsCount: Int
    )

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(): TodaySummary {
        val now = Instant.now().toEpochMilli()
        val sessions = repo.getSessionsForDay(now, ZoneId.systemDefault())
        val total = sessions.sumOf { it.durationSec }
        return TodaySummary(totalSeconds = total, sessionsCount = sessions.size)
    }
}
