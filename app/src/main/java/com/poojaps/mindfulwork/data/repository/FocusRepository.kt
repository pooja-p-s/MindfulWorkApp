package com.poojaps.mindfulwork.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.poojaps.mindfulwork.data.local.dao.FocusSessionDao
import com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

class FocusRepository(private val dao: FocusSessionDao) {
    suspend fun insert(session: FocusSessionEntity) = dao.insert(session)

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getSessionsForDay(epochMillis: Long, zoneId: ZoneId = ZoneId.systemDefault()): List<FocusSessionEntity> {
        val z = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), zoneId)
        val start = z.toLocalDate().atStartOfDay(zoneId).toInstant().toEpochMilli()
        val end = z.toLocalDate().plusDays(1).atStartOfDay(zoneId).toInstant().toEpochMilli()
        return dao.getBetween(start, end)
    }

    suspend fun getWeeklySessions(fromDateEpoch: Long, toDateEpoch: Long) = dao.getBetween(fromDateEpoch, toDateEpoch)

    fun recentSessions(limit: Int = 50): Flow<List<FocusSessionEntity>> = dao.recent(limit)

    suspend fun deleteById(id: String) = dao.deleteById(id)
}
