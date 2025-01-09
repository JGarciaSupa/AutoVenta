package com.lobitoconsulting.autoventa.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@TypeConverters(Converters::class)
@Database(entities = [
//    UserEntity::class,
], version = 3)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
}
