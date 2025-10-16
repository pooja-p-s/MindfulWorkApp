package com.poojaps.mindfulwork.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojaps.mindfulwork.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val userId: String) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(
    private val repo: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow<AuthState>(AuthState.Idle)
    val state: StateFlow<AuthState> = _state

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val result = repo.login(email, password)
            _state.value = result.fold(
                onSuccess = { AuthState.Success(it?.uid ?: "") },
                onFailure = { AuthState.Error(it.message ?: "Unknown error") }
            )
        }
    }

    fun signup(email: String, password: String, name: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val result = repo.signup(email, password, name)
            _state.value = result.fold(
                onSuccess = { AuthState.Success(it?.uid ?: "") },
                onFailure = { AuthState.Error(it.message ?: "Unknown error") }
            )
        }
    }

    fun logout() {
        repo.logout()
        _state.value = AuthState.Idle
    }
}
