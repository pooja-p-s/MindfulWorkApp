package com.poojaps.mindfulwork.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poojaps.mindfulwork.data.local.dao.FocusSessionDao
import com.poojaps.mindfulwork.data.local.dao.MoodDao
import com.poojaps.mindfulwork.data.local.dao.QuoteDao
import com.poojaps.mindfulwork.data.local.entity.FocusSessionEntity
import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.data.local.entity.QuoteEntity

@Database(
    entities = [FocusSessionEntity::class, MoodEntity::class, QuoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun focusSessionDao(): FocusSessionDao
    abstract fun moodDao(): MoodDao
    abstract fun quoteDao(): QuoteDao
}
