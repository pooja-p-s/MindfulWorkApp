package com.poojaps.mindfulwork.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poojaps.mindfulwork.data.local.entity.MoodEntity

@Dao
interface MoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mood: MoodEntity)

    @Query("SELECT * FROM moods WHERE moodDate = :date ORDER BY moodTs DESC")
    suspend fun getByDate(date: String): List<MoodEntity>

    @Query("SELECT * FROM moods WHERE moodDate BETWEEN :from AND :to ORDER BY moodDate DESC, moodTs DESC")
    suspend fun getBetweenDates(from: String, to: String): List<MoodEntity>
}
