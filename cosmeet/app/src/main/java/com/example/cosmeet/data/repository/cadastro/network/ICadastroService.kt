package com.example.cosmeet.data.repository.cadastro.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ICadastroService {
    suspend fun makeCadastroSecondStep(
        @Query("razaoSocial") razaoSocial: String,
        @Query("nomeEmpresarial") nomeFantasia: String,
        @Query("telefone") telefone: String,
        @Query("cnpj") cnpj: String,
        ): Response<ResponseBody>


    suspend fun makeCadastroFirstStep(
        @Query("nomeCompleto") nomeCompleto: String,
        @Query("emailPessoal") emailPessoal: String,
        @Query("senhaPessoal") senhaPessoal: String
    ): Response<ResponseBody>

    @POST("/api/business")
    suspend fun makeCadastroCompleto(
        @Body request: CadastroRequest // Use @Body para enviar os dados no corpo da requisição
    ): Response<ResponseBody>

//    @GET("users")
//    suspend fun isEmailAvailable(@Query("email") emailPessoal: String): Response<ResponseBody>
}