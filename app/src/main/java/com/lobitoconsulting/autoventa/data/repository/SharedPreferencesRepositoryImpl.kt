package com.lobitoconsulting.autoventa.data.repository

import android.content.Context
import com.lobitoconsulting.autoventa.domain.repository.PreferencesRepository

class SharedPreferencesRepositoryImpl (
    private val context: Context
) : PreferencesRepository {

    private val sharedPreferences = context.getSharedPreferences("my_shared_preferences", Context.MODE_PRIVATE)

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    override fun setString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
}