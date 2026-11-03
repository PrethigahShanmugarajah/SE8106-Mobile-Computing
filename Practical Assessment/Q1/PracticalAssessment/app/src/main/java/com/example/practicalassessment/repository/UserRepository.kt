package com.example.practicalassessment.repository

import com.example.practicalassessment.data.User
import com.example.practicalassessment.data.UserDao

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun loginUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }
}