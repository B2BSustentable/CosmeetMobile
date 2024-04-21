package com.example.cosmeet
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    const val BASE_URL_FILMES = "https://localhost:8080/" //nao sei qual é

    /*
    fun getApiService(): Api {
        val cliente =
            Retrofit.Builder()
                .baseUrl(BASE_URL_FILMES)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(::class.java)

        return cliente
    }
     */
}