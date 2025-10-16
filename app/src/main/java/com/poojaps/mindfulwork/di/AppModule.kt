package com.poojaps.mindfulwork.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import com.poojaps.mindfulwork.data.local.db.AppDatabase
import com.poojaps.mindfulwork.data.prefs.SettingsDataStore
import com.poojaps.mindfulwork.data.repository.FocusRepository
import com.poojaps.mindfulwork.data.repository.MoodRepository
import com.poojaps.mindfulwork.data.repository.QuoteRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // --- Database ---
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "mindful-db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFocusRepository(db: AppDatabase): FocusRepository =
        FocusRepository(db.focusSessionDao())

    @Provides
    fun provideMoodRepository(db: AppDatabase): MoodRepository =
        MoodRepository(db.moodDao())

    @Provides
    fun provideQuoteRepository(db: AppDatabase): QuoteRepository =
        QuoteRepository(db.quoteDao())

    @Provides
    @Singleton
    fun provideSettingsDataStore(@ApplicationContext context: Context): SettingsDataStore =
        SettingsDataStore(context)
}
