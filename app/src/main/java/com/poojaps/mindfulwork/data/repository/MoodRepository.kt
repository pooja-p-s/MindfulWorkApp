package com.poojaps.mindfulwork.data.repository

import com.poojaps.mindfulwork.data.local.dao.MoodDao
import com.poojaps.mindfulwork.data.local.entity.MoodEntity

class MoodRepository(private val dao: MoodDao) {
    suspend fun insert(mood: MoodEntity) = dao.insert(mood)

    suspend fun getMoodsForDate(date: String): List<MoodEntity> = dao.getByDate(date)

    suspend fun getMoodsBetween(fromDate: String, toDate: String): List<MoodEntity> = dao.getBetweenDates(fromDate, toDate)
}
