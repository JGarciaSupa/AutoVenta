package com.lobitoconsulting.autoventa.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lobitoconsulting.autoventa.data.local.database.dao.UserDao
import com.lobitoconsulting.autoventa.data.local.model.UserEntity


@TypeConverters(Converters::class)
@Database(entities = [
    UserEntity::class,
], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
