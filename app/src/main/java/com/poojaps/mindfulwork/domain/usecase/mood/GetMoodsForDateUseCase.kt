package com.poojaps.mindfulwork.domain.usecase.mood

import com.poojaps.mindfulwork.data.local.entity.MoodEntity
import com.poojaps.mindfulwork.data.repository.MoodRepository
import javax.inject.Inject

class GetMoodsForDateUseCase @Inject constructor(
    private val repo: MoodRepository
) {
    suspend operator fun invoke(date: String): List<MoodEntity> = repo.getMoodsForDate(date)
}
