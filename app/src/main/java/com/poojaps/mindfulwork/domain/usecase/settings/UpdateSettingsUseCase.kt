package com.poojaps.mindfulwork.domain.usecase.settings

import com.poojaps.mindfulwork.data.prefs.SettingsDataStore
import javax.inject.Inject

class UpdateSettingsUseCase @Inject constructor(
    private val dataStore: SettingsDataStore
) {
    suspend fun updateDisplayName(name: String) {
        dataStore.updateDisplayName(name)
    }

    suspend fun updateDarkMode(enabled: Boolean) {
        dataStore.updateDarkMode(enabled)
    }

    suspend fun updateNotifications(enabled: Boolean) {
        dataStore.updateNotifications(enabled)
    }
}
