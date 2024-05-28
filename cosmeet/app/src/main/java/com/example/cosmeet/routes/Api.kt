package com.example.cosmeet.routes

import com.example.cosmeet.domain.dto.BusinessRequest
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.domain.dto.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun getUser(
        @Query("email") email: String?,
        @Query("password") password: String?
    ): Response<UserResponse>

    @GET("business/{id}")
    suspend fun getBusinessById(
        @Path("id") userId: Long?
    ): Response<BusinessResponse>

    @GET("business")
    suspend fun getAllBusiness(): Response<List<BusinessResponse>>

    @POST("business")
    suspend fun createBusiness(
        @Body novoBusiness:BusinessRequest
    ): Response<BusinessResponse>
}