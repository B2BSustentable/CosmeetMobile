import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class SharedViewModel : ViewModel() {
    private val _nomeCompleto = mutableStateOf("")
    val nomeCompleto: State<String> get() = _nomeCompleto

    private val _emailPessoal = mutableStateOf("")
    val emailPessoal: State<String> get() = _emailPessoal

    private val _senhaPessoal = mutableStateOf("")
    val senhaPessoal: State<String> get() = _senhaPessoal

    fun updateNomeCompleto(nome: String) {
        _nomeCompleto.value = nome
    }

    fun updateEmailPessoal(email: String) {
        _emailPessoal.value = email
    }

    fun updateSenhaPessoal(senha: String) {
        _senhaPessoal.value = senha
    }

}
