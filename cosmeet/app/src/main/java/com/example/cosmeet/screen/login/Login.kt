package com.example.cosmeet.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cosmeet.R
import com.example.cosmeet.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {
    val isSecondStepVisible = remember { mutableStateOf(false) }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    @Composable
    fun FirstStepLoginScreen(onLoginClick: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.width(250.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF432D67),
                                fontSize = 30.sp
                            )
                        ) {
                            append("COSMEET")
                        }
                    }
                )

            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Bem-vindo(a) ao Cosmeet!",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Entre com seu e-mail e senha para acessar sua conta.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    loginViewModel.login(email.value, password.value)
                          },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
            ) {
                Text("Entrar", color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("Não tem uma conta? ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Crie uma agora!")
                    }
                },
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable { /* TODO: Navegar para tela de cadastro */ }
            )
        }
    }

    @Composable
    fun SecondStepLoginScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.width(250.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF432D67),
                                fontSize = 30.sp
                            )
                        ) {
                            append("COSMEET")
                        }
                    }
                )
            }
            Text(
                text = "Verificação em duas etapas",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Um código de segurança foi enviado para o seu número de telefone.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Código de segurança") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF432D67))

            ) {
                Text("Validar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Não recebeu o código?",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.clickable { /* TODO: Reenviar o código */ }
            )

            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "Reenviar o código",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.clickable { /* TODO: Reenviar o código */ }
            )
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        if (!isSecondStepVisible.value) {
            FirstStepLoginScreen(onLoginClick = { isSecondStepVisible.value = true })
        } else {
            SecondStepLoginScreen()
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Esqueceu sua senha?",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable { /* TODO: Implementar recuperação de senha */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = buildAnnotatedString {
                append("Não tem uma conta? ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Crie uma agora!")
                }
            },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable { /* TODO: Navegar para tela de cadastro */ }
        )
    }
}