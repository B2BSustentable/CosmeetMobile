package com.example.cosmeet
import com.example.cosmeet.controller.BusinessController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {
    const val BASE_URL_BANCO = "jdbc:postgresql://ep-mute-wind-62332309.us-east-2.aws.neon.tech/cosmeet?user=jgmatosmota&password=OVkEtdU2ZfY8&sslmode=require"


    fun getApiService(): BusinessController {
        val business =
            Retrofit.Builder()
                .baseUrl(BASE_URL_BANCO)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BusinessController::class.java)

        return business
    }

}