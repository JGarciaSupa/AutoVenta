package com.lobitoconsulting.autoventa.domain.usecase.user

import com.lobitoconsulting.autoventa.domain.model.User
import com.lobitoconsulting.autoventa.domain.repository.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User): User {
        return userRepository.insertUser(user)
    }
}
