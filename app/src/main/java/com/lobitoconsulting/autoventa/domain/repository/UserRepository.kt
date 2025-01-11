package com.lobitoconsulting.autoventa.domain.repository

import com.lobitoconsulting.autoventa.domain.model.User

interface UserRepository {
    suspend fun insertUser(user: User): User
//    suspend fun getUserByUsername(username: String): User?
//    suspend fun updateFlagById(userId: Long, flag: Int) // Actualiza usando el ID en lugar del username
//    suspend fun getLoggedInUser(): User?
//    suspend fun logoutUser() // Método para hacer logout
}
