package com.poojaps.mindfulwork.domain.usecase.mood

import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.data.repository.MoodRepository
import javax.inject.Inject

class LogMoodUseCase @Inject constructor(
    private val repo: MoodRepository
) {
    suspend operator fun invoke(mood: MoodEntity) = repo.insert(mood)
}
