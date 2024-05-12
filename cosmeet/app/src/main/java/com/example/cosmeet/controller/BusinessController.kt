package com.example.cosmeet.controller

import com.example.cosmeet.domain.entity.Business
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BusinessController {
    @GET("/business")
    suspend fun get(): Response<List<Business>>

    @GET("/business/{id}")
    suspend fun get(@Path("id") id:Int): Response<Business>

    @POST("/business")
    suspend fun post(@Body newBusiness: Business): Response<Business>

}

