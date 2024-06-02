package com.example.cosmeet.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.domain.dto.BusinessRequest
import com.example.cosmeet.domain.entity.Plans
import com.example.cosmeet.domain.entity.User
import kotlinx.coroutines.launch
import sptech.projeto08c.RetrofitService

class CadastroViewModel: ViewModel() {
    private val apiBackend = RetrofitService.getApi()
    private val _erroApi = MutableLiveData<String>("")
    val erroApi: LiveData<String> get() = _erroApi

    private val _isBusinessCreated = MutableLiveData<Boolean>()
    val isBusinessCreated: LiveData<Boolean> get() = _isBusinessCreated

    fun makeBusinessRequest(
        nomePessoal: String?,
        emailPessoal: String?,
        senhaPessoal: String?,
        nomeEmpresa: String?,
        emailEmpresa: String?,
        phoneEmpresa: String?,
        cnpjEmpresa: String?,
        occupation: String?,
    ): BusinessRequest {
        return BusinessRequest(
            name = nomeEmpresa,
            email = emailEmpresa,
            phone = phoneEmpresa,
            cnpj = cnpjEmpresa,
            about = occupation,
            photo = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png",
            occupation = occupation,
            user = User(
                id = null,
                name = nomePessoal,
                email = emailPessoal,
                password = senhaPessoal
            ),
            plans = Plans(
                id = 2,
                name = null,
                price = null,
                favorite = null,
                limitSearch = null,
                limitCategory = null,
            )
        )
    }

    fun create(novoBusiness: BusinessRequest) {
        viewModelScope.launch {
            try {
                Log.d("aaaa", novoBusiness.toString())
                Log.d("api", "Vai fazer o post!")
                val post = apiBackend.createBusiness(novoBusiness)
                if (post.isSuccessful) {
                    Log.d("api", "Deu bom no post!")
                    _isBusinessCreated.postValue(true)
                    _erroApi.postValue("")
                } else {
                    Log.e("api", "Deu ruim no post! ${post.errorBody()?.string()}")
                    _isBusinessCreated.postValue(false)
                    _erroApi.postValue(post.errorBody()?.string())
                }
            } catch (e: Exception) {
                Log.e("api", "Deu ruim no post! ${e.message}")
                _isBusinessCreated.postValue(false)
                _erroApi.postValue(e.message)
            }
        }
    }
}
