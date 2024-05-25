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
    private val apiBackend = RetrofitService.getApi()

    fun login(email: String?, password: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiBackend.getUser(email, password)

                if (response.isSuccessful) {
                    Log.d("DEU CERTO", "Login funciona")
                    login.postValue(response.body())
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }
}