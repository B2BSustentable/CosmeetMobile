package com.example.cosmeet.data.repository.cadastro.network

data class CadastroRequest(
    val nome: String,
    val email: String,
    val telefone: String,
    val cnpj: String,
    val about: String,
    val photo: String,
    val occupation: String,
    val user: User,
    val plan: Plan
)
