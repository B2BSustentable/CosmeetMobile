package com.example.cosmeet.data.repository.login

import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.login.network.LoginService

class LoginRepository(
    private val service: LoginService
) {

    suspend fun makeLogin(email: String, senha: String): Resource<String> {
        val resource = service.login(email, senha)

        return if (resource is Resource.Success) {
            Resource.Success("")
        } else {
            resource as Resource.Fail
        }
    }
}