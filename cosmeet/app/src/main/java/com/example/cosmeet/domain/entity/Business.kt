package com.example.cosmeet.domain.entity

import kotlinx.serialization.Serializable

data class Business(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var cnpj: String? = null,
    var occupation: String? = null,
    var about: String? = null,
    var photo: String? = null,
    var user: User? = null,
    var plans: Plans? = null,
    )
