package com.lobitoconsulting.autoventa.di.modules

import com.lobitoconsulting.autoventa.data.repository.SharedPreferencesRepositoryImpl
import com.lobitoconsulting.autoventa.domain.repository.PreferencesRepository
import com.lobitoconsulting.autoventa.domain.usecase.shared.GetPreferenceUseCase
import com.lobitoconsulting.autoventa.domain.usecase.shared.SetPreferenceUseCase
import org.koin.dsl.module

val useCaseModule = module {
//    factory { LogoutUserUseCase(get()) }
//    factory { VerificateUserUseCase(get()) }
//    factory { InsertUserUseCase(get()) }
//    factory { ValidateUserUseCase(get()) }
//    factory { UpdateFlagUserUseCase(get()) }
    factory { GetPreferenceUseCase(get()) }
    factory { SetPreferenceUseCase(get()) }


//    single<UserRepository> { UserRepositoryImpl(get()) }
    single<PreferencesRepository> { SharedPreferencesRepositoryImpl(get()) }
}
