package com.poojaps.mindfulwork.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.domain.usecase.GetTodaySummaryUseCase
import com.poojaps.mindfulwork.domain.usecase.SaveFocusSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FocusTimerViewModel @Inject constructor(
    private val saveSession: SaveFocusSessionUseCase,
    private val getTodaySummary: GetTodaySummaryUseCase
) : ViewModel() {

    private val _timeLeft = MutableStateFlow(0)
    val timeLeft: StateFlow<Int> = _timeLeft

    private val _totalTime = MutableStateFlow(0)
    val totalTime: StateFlow<Int> = _totalTime

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private val _todaySummary = MutableStateFlow(GetTodaySummaryUseCase.TodaySummary(0, 0))
    val todaySummary: StateFlow<GetTodaySummaryUseCase.TodaySummary> = _todaySummary

    fun updateState(total: Int, left: Int, running: Boolean) {
        _totalTime.value = total
        _timeLeft.value = left
        _isRunning.value = running
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refreshTodaySummary() {
        viewModelScope.launch {
            _todaySummary.value = getTodaySummary()
        }
    }
}
