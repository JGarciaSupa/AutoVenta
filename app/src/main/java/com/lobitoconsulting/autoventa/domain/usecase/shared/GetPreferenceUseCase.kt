package com.lobitoconsulting.autoventa.domain.usecase.shared

import com.lobitoconsulting.autoventa.domain.repository.PreferencesRepository

class GetPreferenceUseCase(private val preferencesRepository: PreferencesRepository) {
    operator fun invoke(key: String): String? {
        return preferencesRepository.getString(key)
    }
}
