package com.poojaps.mindfulwork.data.local.dao

import androidx.room.*
import com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FocusSessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: FocusSessionEntity)

    @Query("SELECT * FROM focus_sessions WHERE startTs >= :from AND startTs < :to ORDER BY startTs DESC")
    suspend fun getBetween(from: Long, to: Long): List<FocusSessionEntity>

    @Query("SELECT * FROM focus_sessions ORDER BY startTs DESC LIMIT :limit")
    fun recent(limit: Int = 50): Flow<List<FocusSessionEntity>>

    @Query("DELETE FROM focus_sessions WHERE id = :id")
    suspend fun deleteById(id: String)
}
