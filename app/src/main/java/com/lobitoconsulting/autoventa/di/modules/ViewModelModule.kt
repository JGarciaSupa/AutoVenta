package com.lobitoconsulting.autoventa.di.modules

import com.lobitoconsulting.autoventa.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        LoginViewModel(context = get(),getPreferenceUseCase = get(), setPreferenceUseCase = get())
    }
//    viewModel {
//        RegisterViewModel(context = get(), insertUserUseCase = get())
//    }
//    viewModel{
//        //HomeViewModel(get(), get(named(Constants.BLUETOOTH)), get(named(Constants.RED)), get(named(Constants.POS)))
//        HomeViewModel(context = get() ,bluetoothCommandHandler = get(named(Constants.BLUETOOTH)), getPreferenceUseCase = get(), setPreferenceUseCase = get())
//    }
//    viewModel{
//        ConfigurationViewModel(context = get(), logoutUserUseCase = get(), getPreferenceUseCase = get(), setPreferenceUseCase = get())
//    }

}