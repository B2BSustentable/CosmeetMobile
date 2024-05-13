package com.example.cosmeet.screen.cadastro

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.data.repository.ProcessStatus
import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.cadastro.CadastroRepository
import com.example.cosmeet.data.repository.cadastro.network.CadastroRequest
import kotlinx.coroutines.launch

class CadastroViewModel(
    private val repository: CadastroRepository
) : ViewModel() {
    var nomeCompleto by mutableStateOf("")
    var emailPessoal by mutableStateOf("")
    var senhaPessoal by mutableStateOf("")
    fun makeCadastroFirstStep(nomeCompleto: String, emailPessoal: String, senhaPessoal: String) {
        viewModelScope.launch {
            val resource = repository.makeCadastroFirstStep(nomeCompleto, emailPessoal, senhaPessoal)

            if (resource is Resource.Success) {
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

    fun makeCadastroSecondStep(razaoSocial: String, nomeEmpresarial: String, telefone: String, cnpj: String) {
        viewModelScope.launch {
            val resource = repository.makeCadastroSecondStep(razaoSocial, nomeEmpresarial, telefone, cnpj)

            if (resource is Resource.Success) {
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

    fun makeCadastroCompleto(cadastroRequest: CadastroRequest) {
        viewModelScope.launch {
            val resource = repository.makeCadastroCompleto(cadastroRequest)

            if (resource is Resource.Success) {
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

    fun atualizarNomeCompleto(nome: String) {
        nomeCompleto = nome
    }

    fun atualizarEmailPessoal(email: String) {
        emailPessoal = email
    }

    fun atualizarSenhaPessoal(senha: String) {
        senhaPessoal = senha
    }

//    fun checkEmailAvailability(email: String, callback: (Boolean) -> Unit) {
//        viewModelScope.launch {
//            val isAvailable = repository.isEmailAvailable(email)
//            callback(isAvailable)
//        }
//    }
}