package com.example.cosmeet.routes

import com.example.cosmeet.domain.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/users")
    suspend fun getUser(
        @Query("email") email: String?,
        @Query("password") password: String?
    ): Response<LoginResponse>


//    @GET("/filmes/{id}")
//    suspend fun get(@Path("id") id:Int): Response<Filme>
//    @POST("/filmes")
//    suspend fun post(@Body novoFilme:Filme): Response<Filme>
//    @PUT("/filmes/{id}")
//    suspend fun put(@Path("id") id:Int, @Body filmeEditado:Filme): Response<Filme>
//    @DELETE("/filmes/{id}")
//    suspend fun delete(@Path("id") id:Int): Response<Void>
}