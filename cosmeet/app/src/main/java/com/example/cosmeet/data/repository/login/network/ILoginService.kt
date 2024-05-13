package com.example.cosmeet.data.repository.login.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILoginService {

    @GET("users")
    suspend fun makeLogin(
        @Query("email") email: String,
        @Query("password") senha: String
    ): Response<LoginDto>

}