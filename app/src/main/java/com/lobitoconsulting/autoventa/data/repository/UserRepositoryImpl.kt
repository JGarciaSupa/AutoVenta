package com.lobitoconsulting.autoventa.data.repository

import com.lobitoconsulting.autoventa.data.local.database.dao.UserDao
import com.lobitoconsulting.autoventa.data.local.model.UserEntity
import com.lobitoconsulting.autoventa.domain.model.User
import com.lobitoconsulting.autoventa.domain.repository.UserRepository

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override suspend fun insertUser(user: User): User {
        val entity = UserEntity(username = user.username, password = user.password)
        val userId = userDao.insertUser(entity)
        return User(userId, user.username, user.password)
    }
//
//    override suspend fun getUserByUsername(username: String): User? {
//        val entity = userDao.getUserByUsername(username)
//        return entity?.let { User(it.id, it.username, it.password) }
//    }
//
//    override suspend fun updateFlagById(userId: Long, flag: Int) {
//        userDao.updateFlagById(userId, flag)
//    }
//
//    override suspend fun getLoggedInUser(): User? {
//        val entity = userDao.getLoggedInUser()
//        return entity?.let { User(it.id, it.username, it.password) }
//    }
//
//    override suspend fun logoutUser() {
//        val loggedInUser = userDao.getLoggedInUser()
//        loggedInUser?.let {
//            userDao.updateFlagById(it.id, 1) // Cambiamos el flag a 1 (sesión terminada)
//        }
//    }
}