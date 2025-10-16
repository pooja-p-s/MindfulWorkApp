package com.poojaps.mindfulwork.di

import com.poojaps.mindfulwork.data.repository.MoodRepository
import com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase
import com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoodModule {

    @Provides
    @Singleton
    fun provideLogMoodUseCase(repo: MoodRepository): LogMoodUseCase =
        LogMoodUseCase(repo)

    @Provides
    @Singleton
    fun provideGetMoodsForDateUseCase(repo: MoodRepository): GetMoodsForDateUseCase =
        GetMoodsForDateUseCase(repo)
}
