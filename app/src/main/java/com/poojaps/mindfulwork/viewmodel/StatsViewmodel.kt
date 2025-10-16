package com.poojaps.mindfulwork.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.domain.usecase.stats.GetWeeklyStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getWeeklyStats: GetWeeklyStatsUseCase
) : ViewModel() {

    private val _weeklyStats = MutableStateFlow<List<GetWeeklyStatsUseCase.DailyStat>>(emptyList())
    val weeklyStats: StateFlow<List<GetWeeklyStatsUseCase.DailyStat>> = _weeklyStats

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadWeeklyStats(todayEpochMs: Long) {
        viewModelScope.launch {
            _weeklyStats.value = getWeeklyStats(todayEpochMs)
        }
    }
}
