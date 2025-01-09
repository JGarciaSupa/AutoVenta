package com.lobitoconsulting.autoventa.domain.repository

interface PreferencesRepository {
    fun getString(key: String): String?
    fun setString(key: String, value: String)
}
