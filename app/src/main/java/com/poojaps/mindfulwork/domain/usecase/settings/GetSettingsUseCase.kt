package com.poojaps.mindfulwork.domain.usecase.settings

import com.poojaps.mindfulwork.data.prefs.SettingsDataStore
import com.poojaps.mindfulwork.data.prefs.SettingsDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(
    private val dataStore: SettingsDataStore
) {
    operator fun invoke(): Flow<SettingsDto> = dataStore.settingsFlow
}
