package com.lobitoconsulting.autoventa.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lobitoconsulting.autoventa.data.local.model.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {
    @Insert
    suspend fun insertUser(user: UserEntity): Long

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): UserEntity?

    @Query("UPDATE users SET flag = :flag WHERE id = :userId")
    suspend fun updateFlagById(userId: Long, flag: Int)

    @Query("SELECT * FROM users WHERE flag = 0 LIMIT 1") // Buscar usuario con flag 0 (sesión pendiente)
    suspend fun getLoggedInUser(): UserEntity?
}