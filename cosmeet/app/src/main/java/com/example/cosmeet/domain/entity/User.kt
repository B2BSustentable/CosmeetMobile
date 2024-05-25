package com.example.cosmeet.domain.entity

data class User(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
)
