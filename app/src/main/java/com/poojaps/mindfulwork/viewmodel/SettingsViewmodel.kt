package com.poojaps.mindfulwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.data.prefs.SettingsDto
import com.poojaps.mindfulwork.domain.usecase.settings.GetSettingsUseCase
import com.poojaps.mindfulwork.domain.usecase.settings.UpdateSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    getSettings: GetSettingsUseCase,
    private val updateSettings: UpdateSettingsUseCase
) : ViewModel() {

    val settings: StateFlow<SettingsDto> = getSettings()
        .stateIn(viewModelScope, SharingStarted.Eagerly, SettingsDto())

    fun setDisplayName(name: String) = viewModelScope.launch {
        updateSettings.updateDisplayName(name)
    }

    fun setDarkMode(enabled: Boolean) = viewModelScope.launch {
        updateSettings.updateDarkMode(enabled)
    }

    fun setNotifications(enabled: Boolean) = viewModelScope.launch {
        updateSettings.updateNotifications(enabled)
    }
}
