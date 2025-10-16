package com.poojaps.mindfulwork.data.model

data class UserProfile(
    val uid: String = "",
    val email: String = "",
    val name: String = "",
    val joinedAt: Long = System.currentTimeMillis()
)
