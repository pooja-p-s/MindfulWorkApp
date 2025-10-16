package com.poojaps.mindfulwork.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<FirebaseUser?>
    suspend fun signup(email: String, password: String, name: String): Result<FirebaseUser?>
    fun logout()
    fun getCurrentUser(): FirebaseUser?
}
