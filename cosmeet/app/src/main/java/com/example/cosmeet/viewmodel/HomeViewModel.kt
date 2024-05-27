package com.example.cosmeet.viewmodel

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.domain.dto.BusinessResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class HomeViewModel: ViewModel() {
    private val _business = MutableLiveData<List<BusinessResponse>>()
    val business: LiveData<List<BusinessResponse>> get() = _business

    val erroApi = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    private val apiBackend = RetrofitService.getApi()

    fun getAllBusiness() {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiBackend.getAllBusiness()

                if (response.isSuccessful) {
                    _business.postValue(response.body() ?: emptyList())
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