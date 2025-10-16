package com.poojaps.mindfulwork.di

import android.content.Context
import androidx.room.Room
import com.poojaps.mindfulwork.data.local.db.AppDatabase
import com.poojaps.mindfulwork.data.prefs.SettingsDataStore
import com.poojaps.mindfulwork.data.repository.FocusRepository
import com.poojaps.mindfulwork.data.repository.MoodRepository
import com.poojaps.mindfulwork.data.repository.QuoteRepository

object DatabaseModule {
    private var dbInstance: AppDatabase? = null

    fun provideDatabase(context: Context): AppDatabase {
        return dbInstance ?: synchronized(this) {
            Room.databaseBuilder(context, AppDatabase::class.java, "mindful-db")
                .fallbackToDestructiveMigration()
                .build()
                .also { dbInstance = it }
        }
    }

    fun provideFocusRepository(context: Context): FocusRepository {
        val db = provideDatabase(context)
        return FocusRepository(db.focusSessionDao())
    }

    fun provideMoodRepository(context: Context): MoodRepository {
        val db = provideDatabase(context)
        return MoodRepository(db.moodDao())
    }

    fun provideQuoteRepository(context: Context): QuoteRepository {
        val db = provideDatabase(context)
        return QuoteRepository(db.quoteDao())
    }

    fun provideSettingsDataStore(context: Context): SettingsDataStore = SettingsDataStore(context)
}
