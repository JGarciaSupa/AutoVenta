package com.lobitoconsulting.autoventa

import android.app.Application
import com.lobitoconsulting.autoventa.di.modules.appModule
import com.lobitoconsulting.autoventa.di.modules.dataModule
import com.lobitoconsulting.autoventa.di.modules.useCaseModule
import com.lobitoconsulting.autoventa.di.modules.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, dataModule,viewModule,useCaseModule ) //servicemodule
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}
