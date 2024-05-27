package com.example.cosmeet.domain.dto

import com.example.cosmeet.domain.entity.Address
import kotlinx.serialization.Serializable

@Suppress("PLUGIN_IS_NOT_ENABLED")
@Serializable
data class BusinessResponse(
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var cnpj: String? = null,
    var occupation: String? = null,
    var about: String? = null,
    var photo: String? = null,
    var address: Address? = null,
)
