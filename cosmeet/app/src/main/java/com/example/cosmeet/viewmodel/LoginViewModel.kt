package com.example.cosmeet.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmeet.domain.dto.LoginRequest
import com.example.cosmeet.domain.dto.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class LoginViewModel: ViewModel() {
    val login = MutableLiveData<LoginResponse?>()
    val erroApi = MutableLiveData("")
    val isLoading = MutableLiveData(false)
    private val apiBackend = RetrofitService.getApi()

    fun login(email: String, password: String) {
        Log.d("***", "1")
        isLoading.postValue(true)
        Log.d("***", "2")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("***", "3")

                val response = apiBackend.getUser(email, password)
                Log.d("***", "4")

                if (response.isSuccessful) {
                    Log.d("***", "1")

                    Log.d("DEU CERTO", "Login funciona")
                    login.postValue(response.body())
                    erroApi.postValue("")
                } else {
                    Log.d("***", "2")

                    erroApi.postValue(response.errorBody()?.string())
                }
                Log.d("***", "5")

            } catch (e: Exception) {
                erroApi.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}
