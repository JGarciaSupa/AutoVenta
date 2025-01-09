package com.lobitoconsulting.autoventa.di.modules

import android.content.Context
import com.lobitoconsulting.autoventa.data.repository.SharedPreferencesRepositoryImpl
import com.lobitoconsulting.autoventa.domain.repository.PreferencesRepository
import org.koin.dsl.module

val appModule = module {
// Provee el repositorio de SharedPreferences
    single<PreferencesRepository> { provideSharedPreferencesRepository(get()) }

}

fun provideSharedPreferencesRepository(context: Context): SharedPreferencesRepositoryImpl {
    return SharedPreferencesRepositoryImpl(context)
}
