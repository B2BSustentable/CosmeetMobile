package com.example.cosmeet.domain.dto

data class UserRequest(
    var email: String? = null,
    var password: String? = null,
)

data class UserResponse(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
)
