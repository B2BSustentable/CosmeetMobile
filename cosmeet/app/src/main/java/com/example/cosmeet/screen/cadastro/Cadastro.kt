package com.example.cosmeet.screen.cadastro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cosmeet.R
import com.example.cosmeet.screen.login.LoginScreen
import com.example.cosmeet.ui.theme.CosmeetTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
//import com.example.cosmeet.repository.BusinessRepository

@Composable
fun CadastroScreen() {
    var scope = rememberCoroutineScope()
    var context = LocalContext.current
//    var repository = BusinessRepository()

    val razaoSocial = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val CNPJ = remember {
        mutableStateOf("")
    }
    val senha = remember {
        mutableStateOf("")
    }
    val confirmaSenha = remember {
        mutableStateOf("")
    }

    Spacer(modifier = Modifier.height(8.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {

                Text(
                    text = "Crie sua Conta",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Comece agora criando sua conta",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = "logo",
                modifier = Modifier.size(50.dp)
            )

        }

        OutlinedTextField(
            value = "Nome Completo",
            onValueChange = {},
            label = { Text("Nome Completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "E-mail Pessoal",
            onValueChange = {},
            label = { Text("E-mail Pessoal") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Senha",
            onValueChange = {},
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Confirme sua senha",
            onValueChange = {},
            label = { Text("Confirme sua senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
        ) {
            Text("Próximo")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Já possuo uma conta",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.clickable { /* navegar pra segunda etapa */ }
            )
        }
    }
}

@Composable
fun SecondStepRegister() {
    Spacer(modifier = Modifier.height(8.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {

                Text(
                    text = "Crie sua Conta",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Comece agora criando sua conta",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = "logo",
                modifier = Modifier.size(50.dp)
            )

        }
        OutlinedTextField(
            value = "Nome da Empresa",
            onValueChange = {},
            label = { Text("Nome da Empresa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Área de Atuação",
            onValueChange = {},
            label = { Text("Área de Atuação") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Telefone",
            onValueChange = {},
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "E-mail Empresarial",
            onValueChange = {},
            label = { Text("E-mail Empresarial") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "CNPJ",
            onValueChange = {},
            label = { Text("CNPJ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {

                var message = true
                scope.launch(Dispatchers.IO){
                          if(razaoSocial == null){
                              message = false
                          } else if (razaoSocial != null && CNPJ != null){
//                            repository.signupBusiness(razaoSocial,email, CNPJ, senha, confirmaSenha)
                              message = true
                          }
                }

                scope.launch(Dispatchers.Main){
                    if(message){
                        Toast.makeText(context, "Sucesso ao salvar a tarefa",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "A razão social precisa ser preenchida",
                            Toast.LENGTH_SHORT).show()
                    }
                }


            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
        ) {
            Text("Próximo")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Já possuo uma conta",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.clickable { /* navegar pra segunda etapa */ }
            )
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CosmeetTheme {
        SecondStepRegister()
    }
}