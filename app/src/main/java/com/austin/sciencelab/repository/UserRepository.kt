package com.austin.sciencelab.repository


import com.austin.sciencelab.data.UserDao
import com.austin.sciencelab.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }
    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}