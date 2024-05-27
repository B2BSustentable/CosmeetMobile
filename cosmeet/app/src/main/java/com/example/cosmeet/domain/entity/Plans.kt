package com.example.cosmeet.domain.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Plans(
    var id: Long? = null,
    var name: String? = null,
    var price: Double? = null,
    var favorite: Boolean? = null,
    @field:SerializedName("limit_search") var limitSearch: Boolean? = null,
    @field:SerializedName("limit_category") var limitCategory: Int? = null,
)
