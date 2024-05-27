package com.example.cosmeet.data.repository.cadastro.network

import com.example.cosmeet.data.repository.ProcessStatus
import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.RetrofitService

class CadastroService {
    suspend fun cadastroFirstStep(nomeCompleto: String, emailPessoal: String, senhaPessoal: String): Resource<String> {
        return try {
             val response = RetrofitService.cadastro.makeCadastroFirstStep(nomeCompleto, emailPessoal, senhaPessoal)

             if (response.isSuccessful) {
                 Resource.Success("")
             } else {
                 var message = response.code().toString()
                 if (response.body() != null) {
                     message += " - ${response.body()}"
                 }
                 if (response.message().isNotBlank()) {
                     message += " - ${response.message()}"
                 }
                 if (response.errorBody() != null) {
                     message += " - ${response.errorBody()}"
                 }
                 Resource.Fail(ProcessStatus.Fail, message)
             }
            Resource.Success("")
        } catch (e: Exception) {
            Resource.Fail(ProcessStatus.Fail, e.message ?: e.toString())
        }
    }

    suspend fun cadastroSecondStep(razaoSocial: String, nomeEmpresarial: String, telefone: String, cnpj: String): Resource<String> {
        return try {
            val response = RetrofitService.cadastro.makeCadastroSecondStep(razaoSocial, nomeEmpresarial, telefone, cnpj)

            if (response.isSuccessful) {
                Resource.Success("")
            } else {
                var message = response.code().toString()
                if (response.body() != null) {
                    message += " - ${response.body()}"
                }
                if (response.message().isNotBlank()) {
                    message += " - ${response.message()}"
                }
                if (response.errorBody() != null) {
                    message += " - ${response.errorBody()}"
                }
                Resource.Fail(ProcessStatus.Fail, message)
            }
        } catch (e: Exception) {
            Resource.Fail(ProcessStatus.Fail, e.message ?: e.toString())
        }
    }

    suspend fun cadastroCompleto(cadastroRequest: Business): Resource<Business> {
        return try {
            val response = RetrofitService.cadastro.makeCadastroCompleto(cadastroRequest)

            if (response.isSuccessful) {
                Resource.Success(cadastroRequest)
            } else {
                var message = response.code().toString()
                if (response.body() != null) {
                    message += " - ${response.body()}"
                }
                if (response.message().isNotBlank()) {
                    message += " - ${response.message()}"
                }
                if (response.errorBody() != null) {
                    message += " - ${response.errorBody()}"
                }
                Resource.Fail(ProcessStatus.Fail, message)
            }
        } catch (e: Exception) {
            Resource.Fail(ProcessStatus.Fail, e.message ?: e.toString())
        }
    }

//    suspend fun isEmailAvailable(email: String): Boolean {
//        return try {
//            val response = RetrofitService.cadastro.isEmailAvailable(email)
//            response.isSuccessful
//        } catch (e: Exception) {
//            false
//        }
//    }
}