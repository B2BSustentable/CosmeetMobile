package com.example.cosmeet.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmeet.domain.dto.BusinessResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class CompanyProfileViewModel: ViewModel() {
    val business = MutableLiveData<BusinessResponse?>()
    private val apiBackend = RetrofitService.getApi()
    private val errApi = MutableLiveData("")

    fun fetchBusinessById(userId: Long?) {
        Log.d("12345", "pass1fetch")
        Log.d("idcompany", userId.toString())
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("12345", "pass2fetch")

                val response = apiBackend.getBusinessByUserId(userId)
                if (response.isSuccessful) {
                    Log.d("12345", "pass3fetch")
                    Log.d("12345", "pass3.1fetch" + response.body())

                    business.postValue(response.body())

                    Log.d("businessId", business.value.toString())
                } else {
                    Log.d("12345", "pass4fetch")
                    errApi.postValue(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                errApi.postValue(e.message)
            }
        }
    }
}
