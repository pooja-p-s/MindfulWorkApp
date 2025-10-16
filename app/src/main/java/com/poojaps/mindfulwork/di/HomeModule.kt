package com.poojaps.mindfulwork.di

import com.poojaps.mindfulwork.data.repository.QuoteRepository
import com.poojaps.mindfulwork.domain.usecase.home.GetQuoteOfDayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideGetQuoteUseCase(repo: QuoteRepository): GetQuoteOfDayUseCase =
        GetQuoteOfDayUseCase(repo)
}

