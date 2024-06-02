package com.example.cosmeet.domain.dto

import com.example.cosmeet.domain.entity.Address
import com.example.cosmeet.domain.entity.Plans
import com.example.cosmeet.domain.entity.User

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
    var user : User? = null,
)

data class BusinessRequest(
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var cnpj: String? = null,
    var about: String? = null,
    var photo: String? = null,
    var occupation: String? = null,
    var user: User? = null,
    var plans: Plans? = null,
    )