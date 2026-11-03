package com.example.practicalassessment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalassessment.data.User
import com.example.practicalassessment.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun register(
        username: String,
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            try {
                repository.registerUser(
                    User(
                        username = username,
                        email = email,
                        password = password
                    )
                )
                onResult(true)
            } catch (e: Exception) {
                onResult(false)
            }
        }
    }

    fun login(
        username: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            val user = repository.loginUser(username, password)
            onResult(user != null)
        }
    }
}