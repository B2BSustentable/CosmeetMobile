package com.example.cosmeet.domain.entity

data class Plans(
    var idPlan:Int? = null,
    var name: String? = null,
    var price: Double? = null,
    var favorite: Boolean? = null,
    var limitSearch: Boolean? = null,
    var limitCategory: Int? = null
)
