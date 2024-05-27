package com.example.cosmeet.screen.cadastro

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cosmeet.data.repository.ProcessStatus
import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.cadastro.CadastroRepository
import com.example.cosmeet.data.repository.cadastro.network.Business
import kotlinx.coroutines.launch

class CadastroViewModel(
    private val repository: CadastroRepository
) : ViewModel() {
    val nomeCompleto = mutableStateOf("")
    val emailPessoal = mutableStateOf("")
    val senhaPessoal = mutableStateOf("")

    fun makeCadastroFirstStep(nomeCompleto: String, emailPessoal: String, senhaPessoal: String) {
        viewModelScope.launch {
            atualizarNomeCompleto(nomeCompleto)
            atualizarEmailPessoal(emailPessoal)
            atualizarSenhaPessoal(senhaPessoal)

            val resource = repository.makeCadastroFirstStep(nomeCompleto, emailPessoal, senhaPessoal)

            if (resource is Resource.Success) {
                Log.d("***deu bom", "${resource.data}")
            } else if (resource is Resource.Fail) {
                when (resource.status) {
                    ProcessStatus.NoInternet -> Log.d("***deu ruim", "${ProcessStatus.NoInternet}")
                    ProcessStatus.TimeOut -> Log.d("***deu ruim", "${ProcessStatus.TimeOut}")
                    else -> Log.d("***deu ruim", "Erro desconhecido")
                }
            }
        }
    }

    fun makeCadastroSecondStep(razaoSocial: String, emailEmpresarial: String, telefone: String, cnpj: String) {
        viewModelScope.launch {
            val resource = repository.makeCadastroSecondStep(razaoSocial, emailEmpresarial, telefone, cnpj)

            if (resource is Resource.Success) {
                Log.d("***deu bom", "${resource.data}")
            } else if (resource is Resource.Fail) {
                when (resource.status) {
                    ProcessStatus.NoInternet -> Log.d("***deu ruim", "${ProcessStatus.NoInternet}")
                    ProcessStatus.TimeOut -> Log.d("***deu ruim", "${ProcessStatus.TimeOut}")
                    else -> Log.d("***deu ruim", "Erro desconhecido")
                }
            }
        }
    }

    fun makeCadastroCompleto(cadastroRequest: Business) {
        viewModelScope.launch {
            val resource = repository.makeCadastroCompleto(cadastroRequest)

            if (resource is Resource.Success) {
                Log.d("***deu bom", "${resource.data}")
            } else if (resource is Resource.Fail) {
                when (resource.status) {
                    ProcessStatus.NoInternet -> Log.d("***deu ruim", "${ProcessStatus.NoInternet}")
                    ProcessStatus.TimeOut -> Log.d("***deu ruim", "${ProcessStatus.TimeOut}")
                    else -> Log.d("***deu ruim", "Erro desconhecido")
                }
            }
        }
    }

    fun atualizarNomeCompleto(nome: String) {
        nomeCompleto.value = nome
        Log.d("CadastroViewModel", "Nome atualizado para: $nome")
    }

    fun atualizarEmailPessoal(email: String) {
        emailPessoal.value = email
        Log.d("CadastroViewModel", "Email atualizado para: $email")
    }

    fun atualizarSenhaPessoal(senha: String) {
        senhaPessoal.value = senha
        Log.d("CadastroViewModel", "Senha atualizada para: $senha")
    }

    // Função para verificar a disponibilidade do e-mail
    // Função comentada pois não está sendo utilizada no momento
    //fun checkEmailAvailability(email: String, callback: (Boolean) -> Unit) {
    //    viewModelScope.launch {
    //        val isAvailable = repository.isEmailAvailable(email)
    //        callback(isAvailable)
    //    }
    //}
}
