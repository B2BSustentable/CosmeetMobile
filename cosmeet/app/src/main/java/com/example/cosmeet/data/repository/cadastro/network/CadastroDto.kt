package com.example.cosmeet.data.repository.cadastro.network

class CadastroDto {

}

data class User(
    val name: String,
    val email: String,
    val password: String
)

data class Plan(
    val id: Int,
    val name: String,
    val price: Double,
    val favorite: Boolean,
    val limit_search: Boolean,
    val limit_category: Int
)

data class Business(
    val name: String,
    val email: String,
    val phone: String,
    val cnpj: String,
    val about: String,
    val photo: String,
    val occupation: String,
    val user: User,
    val plans: Plan
)
