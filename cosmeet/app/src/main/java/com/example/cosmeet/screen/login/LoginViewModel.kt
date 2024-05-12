package com.example.cosmeet.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.data.repository.ProcessStatus
import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.login.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
): ViewModel()  {

    fun makeLogin(email: String, senha: String) {
        viewModelScope.launch {
            val resource = repository.makeLogin(email, senha)

            if(resource is Resource.Success) {
                Log.d("***deu bom", "${resource.data}")
            } else if (resource is Resource.Fail) {

                when (resource.status) {
                    ProcessStatus.NoInternet -> Log.d("***deu ruim", "${ProcessStatus.NoInternet}")

                    ProcessStatus.TimeOut -> Log.d("***deu ruim", "${ProcessStatus.TimeOut}")

                    else -> {
                        Log.d("***deu ruim", "Error")
                    }
                }
            }
        }
    }

}