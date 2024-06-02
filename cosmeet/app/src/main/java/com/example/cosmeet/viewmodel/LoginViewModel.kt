package com.example.cosmeet.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmeet.domain.UserPreferences
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.domain.dto.UserResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class LoginViewModel: ViewModel() {
    val login = MutableLiveData<UserResponse?>()
    val business = MutableLiveData<BusinessResponse?>()

    val erroApi = MutableLiveData("")
    val isLoading = MutableLiveData(false)
    private val apiBackend = RetrofitService.getApi()

    fun login(context: Context, email: String, password: String) {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiBackend.getUser(email, password)
                if (response.isSuccessful) {
                    Log.d("DEU CERTO", "Login funciona")
                    login.postValue(response.body())

                    val response2 = apiBackend.getBusinessById(response.body()?.id)
                    val businessResponse = response2.body()
                    business.postValue(response2.body())

                    businessResponse?.let {
                        UserPreferences.saveUser(context, it)
                        Log.d("LOGINSD", businessResponse?.name.toString())
                    }

                    erroApi.postValue("")
                } else {

                    erroApi.postValue(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                erroApi.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}
