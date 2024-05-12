package com.example.cosmeet.repository

import androidx.compose.runtime.MutableState
import com.example.cosmeet.service.SignupService

class BusinessRepository() {

    private val signup = SignupService()
    fun signupBusiness(
        razaoSocial: MutableState<String>, email: MutableState<String>,
        CNPJ: MutableState<String>, senha: MutableState<String>,
        confirmarSenha: MutableState<String>
    ){
        signup.signupBusiness(razaoSocial, email,CNPJ, senha, confirmarSenha)


    }
}