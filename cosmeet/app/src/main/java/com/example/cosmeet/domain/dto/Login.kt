package com.example.cosmeet.domain.dto

data class LoginRequest(
    var email: String? = null,
    var password: String? = null,
)

data class LoginResponse(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
)
