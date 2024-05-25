package sptech.projeto08c

import com.example.cosmeet.routes.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    const val BASE_URL = "http://localhost:8080"

    fun getApi(): Api {
        val client =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)

        return client
    }

}