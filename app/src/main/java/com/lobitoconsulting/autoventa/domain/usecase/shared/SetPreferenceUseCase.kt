package com.lobitoconsulting.autoventa.domain.usecase.shared

import com.lobitoconsulting.autoventa.domain.repository.PreferencesRepository

class SetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    operator fun invoke(key: String, value: String) {
        preferencesRepository.setString(key, value)
    }
}