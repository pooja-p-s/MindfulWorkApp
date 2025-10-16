package com.poojaps.mindfulwork.di

import com.poojaps.mindfulwork.data.prefs.SettingsDataStore
import com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase
import com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingsModule {

    @Provides
    @Singleton
    fun provideGetSettingsUseCase(dataStore: SettingsDataStore): GetSettingsUseCase =
        GetSettingsUseCase(dataStore)

    @Provides
    @Singleton
    fun provideUpdateSettingsUseCase(dataStore: SettingsDataStore): UpdateSettingsUseCase =
        UpdateSettingsUseCase(dataStore)
}
