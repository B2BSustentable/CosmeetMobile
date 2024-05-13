package com.example.cosmeet.data.repository
import com.example.cosmeet.data.repository.ExternalRoutes.Companion.BASE_URL
import com.example.cosmeet.data.repository.login.network.ILoginService
import okhttp3.Interceptor
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client  )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val login: ILoginService by lazy {
        retrofit.create(ILoginService::class.java)
    }
}