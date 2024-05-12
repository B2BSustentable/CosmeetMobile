package com.example.cosmeet.data.repository.login.network

import com.example.cosmeet.data.repository.ProcessStatus
import com.example.cosmeet.data.repository.Resource
import com.example.cosmeet.data.repository.RetrofitClient
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoginService {
    suspend fun login(email: String, senha: String): Resource<String> {
       return try {
           val response = RetrofitClient.login.makeLogin(email, senha)

           if (response.isSuccessful) {
               Resource.Success("")
           } else {
               var message = response.code().toString()
               if (response.body() != null) {
                   message += " - ${response.body()}"
               }
               if (response.message().isNotBlank()) {
                   message += " - ${response.message()}"
               }
               if (response.errorBody() != null) {
                   message += " - ${response.errorBody()}"
               }
               Resource.Fail(ProcessStatus.Fail, message)
           }
       } catch (e: UnknownHostException) {
           Resource.Fail(ProcessStatus.NoInternet, e.message ?: e.toString())
       } catch (e: SocketTimeoutException) {
           Resource.Fail(ProcessStatus.TimeOut, e.message ?: e.toString())
       } catch (e: Exception) {
           Resource.Fail(ProcessStatus.Fail, e.message ?: e.toString())
       }
    }
}