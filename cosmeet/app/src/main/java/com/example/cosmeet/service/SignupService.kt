package com.example.cosmeet.service

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import com.example.cosmeet.data.repository.RetrofitClient
import com.example.cosmeet.domain.entity.Business
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class SignupService {
//
//    private val businessContoler = RetrofitClient.getApiService()
//
//    private val db = FirebaseFirestore.getInstance()
//
//    val message = MutableLiveData("")
//
//    val novaEmpresa = MutableLiveData(Business())
//    val empresas = MutableLiveData(SnapshotStateList<Business>())
//
//
//    fun signupBusiness(
//        razaoSocial: MutableState<String>, email: MutableState<String>,
//        CNPJ: MutableState<String>, senha: MutableState<String>,
//        confirmarSenha: MutableState<String>
//    ){
//
//        val businessMap = hashMapOf(
//            "razaoSocial" to razaoSocial,
//            "email" to email,
//            "CNPJ" to CNPJ,
//            "senha" to senha,
//            "confirmarSenha" to confirmarSenha
//        )
//
//        db.collection("business").document(razaoSocial.toString()).
//        set(businessMap).addOnCompleteListener {"Cadastrado com sucesso"}.
//        addOnFailureListener {"Erro ao cadastrar empresa"}
//    }
//
//
//    fun signupBusinessRetrofit(newBusiness: Business) {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val post = businessContoler.post(newBusiness)
//                if (post.isSuccessful) {
////                    recuperarLista()
//                    message.postValue("")
//                } else {
//                    message.postValue(post.errorBody()!!.string())
//                }
//            } catch (e: Exception) {
//                Log.e("api", "Deu ruim no post! ${e.message}")
//                message.postValue(e.message)
//            }
//        }
//    }
//
//}