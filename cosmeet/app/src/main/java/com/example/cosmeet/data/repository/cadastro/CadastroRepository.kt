package com.example.cosmeet.data.repository.cadastro

import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.cadastro.network.CadastroRequest
import com.example.cosmeet.data.repository.cadastro.network.CadastroService

class CadastroRepository (
    private val service: CadastroService
) {
    suspend fun makeCadastroFirstStep(nomeCompleto: String, emailPessoal: String, senhaPessoal: String): Resource<String> {
        val resource = service.cadastroFirstStep(nomeCompleto, emailPessoal, senhaPessoal)

        return if (resource is Resource.Success) {
            Resource.Success("")
        } else {
            resource as Resource.Fail
        }
    }

    suspend fun makeCadastroSecondStep(razaoSocial: String, nomeEmpresarial: String, telefone: String, cnpj: String): Resource<String> {
        val resource = service.cadastroSecondStep(razaoSocial, nomeEmpresarial, telefone, cnpj)

        return if (resource is Resource.Success) {
            Resource.Success("")
        } else {
            resource as Resource.Fail
        }
    }

    suspend fun makeCadastroCompleto(cadastroRequest: CadastroRequest): Resource<CadastroRequest> {
        val resource = service.cadastroCompleto(cadastroRequest)

        return if (resource is Resource.Success) {
            Resource.Success(cadastroRequest)
        } else {
            resource as Resource.Fail
        }
    }

//    suspend fun isEmailAvailable(email: String): Boolean {
//        return service.isEmailAvailable(email)
//    }
}