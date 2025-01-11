package com.lobitoconsulting.autoventa.domain.model

data class User(
    val id: Long = 0,
    val username: String,
    val password: String
)