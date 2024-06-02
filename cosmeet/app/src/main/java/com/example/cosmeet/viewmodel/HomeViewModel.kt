package com.example.cosmeet.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.domain.dto.BusinessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class HomeViewModel : ViewModel() {
    val _business = MutableLiveData<List<BusinessResponse>>()
    val business: LiveData<List<BusinessResponse>> get() = _business

    val erroApi = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    private val apiBackend = RetrofitService.getApi()

    fun getAllBusiness() {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiBackend.getAllBusiness()
                Log.d("HomeViewModel", "Response successful: ${response.isSuccessful}")
                Log.d("HomeViewModel", "Response body: ${response.body()}")

                if (response.isSuccessful) {
                    val businessList = response.body() ?: emptyList()
                    Log.d("HomeViewModel", "Business list size: ${businessList.size}")
                    _business.postValue(businessList)
                    Log.d("HomeViewModel", "Posted business list: $businessList")
                    Log.d("HomeViewModel", "_business: ${_business.value.toString()}")
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                    Log.d("HomeViewModel", "Error body: ${response.errorBody()?.string()}")
                }

            } catch (e: Exception) {
                erroApi.postValue(e.message)
                Log.e("HomeViewModel", "Exception: ${e.message}")
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}
