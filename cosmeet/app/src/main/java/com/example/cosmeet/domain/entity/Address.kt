package com.example.cosmeet.domain.entity

data class Address(
    var id: Long? = null,
    var number: Int? = null,
    var neighborhood: String? = null,
    var city: String? = null,
    var state: String? = null,
    var country: String? = null,
    var zipCode: String? = null,
    var latitude: String? = null,
    var longitude: String? = null,
    var business: Business? = null,
)
