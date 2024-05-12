package com.example.cosmeet.data.repository.cadastro.network

class CadastroDto {

}

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String
)

data class Plan(
    val id: String,
    val name: String,
    val price: String,
    val favorite: String,
    val limit_search: String,
    val limit_category: String
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
