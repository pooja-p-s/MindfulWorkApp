package com.poojaps.mindfulwork.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.domain.usecase.home.GetHomeSummaryUseCase
import com.poojaps.mindfulwork.domain.usecase.home.GetQuoteOfDayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeSummary: GetHomeSummaryUseCase,
    private val getQuoteOfDay: GetQuoteOfDayUseCase,
) : ViewModel() {

    private val _homeSummary = MutableStateFlow<GetHomeSummaryUseCase.HomeSummary?>(null)
    val homeSummary: StateFlow<GetHomeSummaryUseCase.HomeSummary?> = _homeSummary

    private val _quote = MutableStateFlow<GetQuoteOfDayUseCase.QuoteDto?>(null)
    val quote: StateFlow<GetQuoteOfDayUseCase.QuoteDto?> = _quote

    private var refreshJob: Job? = null

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadHome(epochMs: Long) {
        viewModelScope.launch {
            _homeSummary.value = getHomeSummary(epochMs)
            loadQuoteDaily()
        }
    }

    private suspend fun loadQuote() {
        // Use case handles preload internally if needed
        _quote.value = getQuoteOfDay()
    }

    private fun loadQuoteDaily() {
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            // Load once immediately
            loadQuote()

            while (isActive) {
                val now = Calendar.getInstance()
                val nextMidnight = Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_YEAR, 1)
                    set(Calendar.HOUR_OF_DAY, 0)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }

                val delayMillis = nextMidnight.timeInMillis - now.timeInMillis
                delay(delayMillis)

                // Refresh at midnight
                loadQuote()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        refreshJob?.cancel()
    }
}
