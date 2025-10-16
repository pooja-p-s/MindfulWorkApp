package com.poojaps.mindfulwork.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity
import com.poojaps.mindfulwork.data.repository.FocusRepository
import java.time.Instant
import java.util.UUID
import javax.inject.Inject

class SaveFocusSessionUseCase @Inject constructor(
    private val focusRepository: FocusRepository
) {

    /**
     * Saves a focus session to the local database.
     *
     * @param totalSeconds Planned total duration (in seconds)
     * @param focusedSeconds Actual focused duration (in seconds)
     */
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(totalSeconds: Int, focusedSeconds: Int) {
        val now = Instant.now().toEpochMilli()
        val startTime = now - (focusedSeconds * 1000L)

        val session = FocusSessionEntity(
            id = UUID.randomUUID().toString(),
            userId = null, // optional for future
            startTs = startTime,
            endTs = now,
            durationSec = focusedSeconds,
            completed = focusedSeconds >= totalSeconds,
            createdAt = now
        )

        focusRepository.insert(session)
    }
}
