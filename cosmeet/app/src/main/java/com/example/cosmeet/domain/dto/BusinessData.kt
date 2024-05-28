package com.example.cosmeet.domain.dto

import com.example.cosmeet.domain.entity.Plans
import com.example.cosmeet.domain.entity.User

object BusinessData {
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var cnpj: String? = null
    var about: String? = null
    var photo: String? = null
    var occupation: String? = null
    var user: User? = null
    var plans: Plans? = Plans(
        id = 2,
        name = null,
        price = null,
        favorite = null,
        limitSearch = null,
        limitCategory = null
    )
}