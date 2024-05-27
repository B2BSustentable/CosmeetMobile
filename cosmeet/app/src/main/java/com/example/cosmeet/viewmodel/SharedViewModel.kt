package com.example.cosmeet.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmeet.domain.dto.BusinessResponse

class SharedViewModel : ViewModel() {
    val loginResponse = MutableLiveData<BusinessResponse?>()
}