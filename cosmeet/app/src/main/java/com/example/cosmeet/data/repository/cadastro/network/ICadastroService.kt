package com.example.cosmeet.data.repository.cadastro.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ICadastroService {
    @POST("business")
    suspend fun registerUser(@Body body: Business): Response<Unit>
}