package com.poojaps.mindfulwork.di

import com.poojaps.mindfulwork.data.repository.FocusRepository
import com.poojaps.mindfulwork.data.repository.MoodRepository
import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StatsModule {

    @Provides
    @Singleton
    fun provideGetWeeklyStatsUseCase(
        focusRepo: FocusRepository,
        moodRepo: MoodRepository
    ): GetWeeklyStatsUseCase = GetWeeklyStatsUseCase(focusRepo, moodRepo)
}
