package com.example.cosmeet.data.repository

sealed class Resource<out T : Any> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Fail(val status: ProcessStatus, val message: String) : Resource<Nothing>()
    object Processing : Resource<Nothing>()

    override fun toString(): String {
        return when(this){
            is Success -> "Success[data=$data]"
            is Fail -> "Error[status=$status, $message]"
            is Processing -> "Carregando"
        }
    }
}

enum class ProcessStatus {
    Success, Fail, TokenExpired, SaveFail, FailExternalAPI, WrongParameter, Exception, NoInternet, TimeOut
}
