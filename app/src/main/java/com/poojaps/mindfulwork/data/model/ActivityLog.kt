package com.poojaps.mindfulwork.data.model

data class ActivityLog(
    val id: String = "",
    val type: String = "",      // meditation, focus, break
    val duration: Int = 0,      // minutes
    val createdAt: Long = System.currentTimeMillis()
)
