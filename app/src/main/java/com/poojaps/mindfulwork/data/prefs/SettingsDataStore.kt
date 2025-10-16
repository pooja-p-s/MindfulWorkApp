package com.poojaps.mindfulwork.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val PREFERENCES_NAME = "mindful_prefs"
private val Context.dataStore by preferencesDataStore(PREFERENCES_NAME)

object SettingsKeys {
    val DISPLAY_NAME = stringPreferencesKey("display_name")
    val DARK_MODE = booleanPreferencesKey("dark_mode")
    val NOTIFICATIONS = booleanPreferencesKey("notifications_enabled")
}

class SettingsDataStore(private val context: Context) {
    val settingsFlow: Flow<SettingsDto> = context.dataStore.data.map { prefs ->
        SettingsDto(
            displayName = prefs[SettingsKeys.DISPLAY_NAME],
            darkMode = prefs[SettingsKeys.DARK_MODE] ?: false,
            notificationsEnabled = prefs[SettingsKeys.NOTIFICATIONS] ?: true
        )
    }

    suspend fun updateDisplayName(name: String) {
        context.dataStore.edit { prefs ->
            prefs[SettingsKeys.DISPLAY_NAME] = name
        }
    }

    suspend fun updateDarkMode(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SettingsKeys.DARK_MODE] = enabled
        }
    }

    suspend fun updateNotifications(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SettingsKeys.NOTIFICATIONS] = enabled
        }
    }
}

/** Simple DTO for settings */
data class SettingsDto(
    val displayName: String? = null,
    val darkMode: Boolean = false,
    val notificationsEnabled: Boolean = true
)
