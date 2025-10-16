package com.poojaps.mindfulwork.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "focus_sessions")
data class FocusSessionEntity(
    @PrimaryKey val id: String,        // UUID string
    val userId: String? = null,        // optional for future multi-user mapping
    val startTs: Long,                 // epoch millis
    val endTs: Long? = null,
    val durationSec: Int,
    val completed: Boolean,
    val createdAt: Long = System.currentTimeMillis()
)