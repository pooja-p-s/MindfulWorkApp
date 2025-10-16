package com.poojaps.mindfulwork.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.domain.usecase.mood.GetMoodsForDateUseCase
import com.poojaps.mindfulwork.domain.usecase.mood.LogMoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MoodViewModel @Inject constructor(
    private val logMoodUseCase: LogMoodUseCase,
    private val getMoodsForDateUseCase: GetMoodsForDateUseCase
) : ViewModel() {

    private val _moodsForDate = MutableStateFlow<List<MoodEntity>>(emptyList())
    val moodsForDate: StateFlow<List<MoodEntity>> = _moodsForDate

    fun logMood(moodDate: String, moodTs: Long, emoji: String, label: String) {
        viewModelScope.launch {
            val entity = MoodEntity(
                id = UUID.randomUUID().toString(),
                moodDate = moodDate,
                moodTs = moodTs,
                emoji = emoji,
                label = label
            )
            logMoodUseCase(entity)
            loadMoodsForDate(moodDate)
        }
    }

    fun loadMoodsForDate(date: String) {
        viewModelScope.launch {
            _moodsForDate.value = getMoodsForDateUseCase(date)
        }
    }
}
