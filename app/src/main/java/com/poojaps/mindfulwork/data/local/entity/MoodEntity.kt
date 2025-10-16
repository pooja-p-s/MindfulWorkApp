package com.poojaps.mindfulwork.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moods")
data class MoodEntity(
    @PrimaryKey val id: String,
    val userId: String? = null,
    val moodDate: String,   // yyyy-MM-dd
    val moodTs: Long,       // epoch millis
    val emoji: String,
    val label: String,
    val createdAt: Long = System.currentTimeMillis()
)
