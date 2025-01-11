package com.lobitoconsulting.autoventa.di.modules

import android.content.Context
import androidx.room.Room
import com.lobitoconsulting.autoventa.data.local.database.AppDatabase
import com.lobitoconsulting.autoventa.data.local.database.dao.UserDao
import org.koin.dsl.module

val dataModule = module{
    single { provideDatabase(get()) }
    single { provideUserDao(get()) }

}


fun provideDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "autoventa.db"
    )
        .fallbackToDestructiveMigration() // Esto elimina la base de datos y la recrea
        .build()
}

fun provideUserDao(database: AppDatabase): UserDao {
    return database.userDao()
}