package sptech.projeto08c

import com.example.cosmeet.routes.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "http://52.6.50.201:8080/api/"

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