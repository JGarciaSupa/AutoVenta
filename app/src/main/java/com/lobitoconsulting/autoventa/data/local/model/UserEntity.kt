package com.lobitoconsulting.autoventa.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lobitoconsulting.autoventa.data.local.database.Converters
import java.util.Date

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "createDate") val createDate: String = Converters().getDateFormat(),
    @ColumnInfo(name = "flag") val flag: Int ?= 0,
)