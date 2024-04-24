package com.example.cosmeet.screen.login

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun LoginScreen() {
    val isSecondStepVisible = remember { mutableStateOf(false) }

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
            text = "Não tem uma conta? Crie uma agora!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable { /* TODO: Navegar para tela de cadastro */ }
        )
    }
}

@Composable
fun FirstStepLoginScreen(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            value = "E-mail",
            onValueChange = {},
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "Senha",
            onValueChange = {},
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
        ) {
            Text("Entrar")
        }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CosmeetTheme {
        LoginScreen()
    }
}