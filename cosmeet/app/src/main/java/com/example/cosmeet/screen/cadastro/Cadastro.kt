package com.example.cosmeet.screen.cadastro

import SharedViewModel
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cosmeet.R
import com.example.cosmeet.viewmodel.CadastroViewModel

enum class PlanType {
    BASICO, COMMON, PREMIUM
}

@Composable
fun CadastroScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel = viewModel()
) {
    var scope = rememberCoroutineScope()
    var context = LocalContext.current
    val errorMessage by remember { mutableStateOf("") }
    
//    val nomeCompleto = remember { mutableStateOf("") }
//    val emailPessoal = remember { mutableStateOf("") }
//    val senhaPessoal = remember { mutableStateOf("") }
    val confirmaSenha = remember { mutableStateOf("") }

    val nomeCompleto by sharedViewModel.nomeCompleto
    val emailPessoal by sharedViewModel.emailPessoal
    val senhaPessoal by sharedViewModel.senhaPessoal

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
            value = nomeCompleto,
            onValueChange = { sharedViewModel.updateNomeCompleto(it) },
            label = { Text("Nome Completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = emailPessoal,
            onValueChange = { sharedViewModel.updateEmailPessoal(it) },
            label = { Text("E-mail Pessoal") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = senhaPessoal,
            onValueChange = { sharedViewModel.updateSenhaPessoal(it) },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmaSenha.value,
            onValueChange = { confirmaSenha.value = it },
            label = { Text("Confirme sua senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if (nomeCompleto.isNotEmpty() && emailPessoal.isNotEmpty() && senhaPessoal.isNotEmpty()) {
                    navController.navigate("secondStepRegister")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
        ) {
            Text("Próximo", color = Color.White)
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
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
fun SecondStepRegister(
    navController: NavHostController,
    sharedViewModel: SharedViewModel = viewModel(),
    cadastroViewModel: CadastroViewModel = viewModel()
) {
    val errorMessage by remember { mutableStateOf("") }

    val nomeEmpresa = remember { mutableStateOf("") }
    val emailEmpresa = remember { mutableStateOf("") }
    val occupation = remember { mutableStateOf("") }
    val telefone = remember { mutableStateOf("") }
    val CNPJ = remember { mutableStateOf("") }

    val isBusinessCreated by cadastroViewModel.isBusinessCreated.observeAsState()
    val erroApi by cadastroViewModel.erroApi.observeAsState()

    Log.d("***&", sharedViewModel.nomeCompleto.value)

    if (isBusinessCreated == true) {
        navController.navigate("login")
    } else if (isBusinessCreated == false) {
        erroApi?.let {
            if (it.isNotEmpty()) {
                Text("Erro: $it", color = Color.Red)
            }
        }
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
            value = nomeEmpresa.value,
            onValueChange = { nomeEmpresa.value = it},
            label = { Text("Nome da Empresa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Área de Atuação",
            onValueChange = { occupation.value = it },
            label = { Text("Área de Atuação") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = telefone.value,
            onValueChange = { telefone.value = it},
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = emailEmpresa.value,
            onValueChange = { emailEmpresa.value = it},
            label = { Text("E-mail Empresarial") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = CNPJ.value,
            onValueChange = { CNPJ.value = it},
            label = { Text("CNPJ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if (nomeEmpresa.value.isNotEmpty() && telefone.value.isNotEmpty() && emailEmpresa.value.isNotEmpty() && CNPJ.value.isNotEmpty()) {
                    val business = cadastroViewModel.makeBusinessRequest(
                        nomePessoal = sharedViewModel.nomeCompleto.value,
                        emailPessoal = sharedViewModel.emailPessoal.value,
                        senhaPessoal = sharedViewModel.senhaPessoal.value,
                        nomeEmpresa = nomeEmpresa.value,
                        emailEmpresa = emailEmpresa.value,
                        phoneEmpresa = telefone.value,
                        cnpjEmpresa = CNPJ.value,
                        occupation = occupation.value,
                    )

                    cadastroViewModel.create(business)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
        ) {
            Text("Cadastrar")
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Red,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
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
fun PlanoSelecaoScreen(navController: NavHostController) {
    val selectedPlan = remember { mutableStateOf(PlanType.BASICO) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 40.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "back"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Escolha Seu Plano",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Escolha o melhor plano para seu negócio",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Básico",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (selectedPlan.value == PlanType.BASICO) TextDecoration.Underline else TextDecoration.None
                ),
                modifier = Modifier.clickable { selectedPlan.value = PlanType.BASICO }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Common",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (selectedPlan.value == PlanType.COMMON) TextDecoration.Underline else TextDecoration.None
                ),
                modifier = Modifier.clickable { selectedPlan.value = PlanType.COMMON }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Premium",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (selectedPlan.value == PlanType.PREMIUM) TextDecoration.Underline else TextDecoration.None
                ),
                modifier = Modifier.clickable { selectedPlan.value = PlanType.PREMIUM }
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(30.dp))
        when (selectedPlan.value) {
            PlanType.BASICO -> {
                Text(
                    text = "O plano ideal para quem está começando agora na Cosmeet",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quantidade de categorias:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "2",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consulta Limitadas:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Consulta Limitadas"
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(13.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Adicionar aos favoritos:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Adicionar aos favoritos"
                    )
                }

                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "VALOR:",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "R$ 20,00",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))


                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Utilize o quanto quiser",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Utilize o quanto quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Recomendações especiais",
                            modifier = Modifier.height(20.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Recomendações especiais para você.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Altere ou cancele seu plano",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Altere ou cancele seu plano quando quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(70.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                ) {
                    Text("Próximo")
                }

            }

            PlanType.COMMON -> {
                Text(
                    text = "O plano mais utilizado entre os usuários",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quantidade de categorias:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "3",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consulta Limitadas",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Consulta Limitadas"
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(13.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Adicionar aos favoritos:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Adicionar aos favoritos"
                    )
                }

                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "VALOR:",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "R$ 50,00",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))


                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Utilize o quanto quiser",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Utilize o quanto quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Recomendações especiais",
                            modifier = Modifier.height(20.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Recomendações especiais para você.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Altere ou cancele seu plano",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Altere ou cancele seu plano quando quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(70.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                ) {
                    Text("Próximo")
                }
            }

            PlanType.PREMIUM -> {
                Text(
                    text = "O plano ideal para quem está começando agora na Cosmeet",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quantidade de categorias:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Text(
                        text = "5",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consulta ILIMITADAS:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Consulta ILIMITADAS"
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(13.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Adicionar aos favoritos:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )

                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Adicionar aos favoritos"
                    )
                }

                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "VALOR:",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "R$ 100,00",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(30.dp))


                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Utilize o quanto quiser",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Utilize o quanto quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Recomendações especiais",
                            modifier = Modifier.height(20.dp)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Recomendações especiais para você.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Row {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Altere ou cancele seu plano",
                            modifier = Modifier.height(20.dp)

                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = "Altere ou cancele seu plano quando quiser.",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(70.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                ) {
                    Text("Próximo", color = Color.White)
                }

            }
        }
    }
}
@Composable
fun PagamentoScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 40.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "back"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Pagamento",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(painter = painterResource(id = R.mipmap.logo), contentDescription = "logo", modifier = Modifier.size(50.dp))
        }
        Text(
            text = "Confirme o pagamento para prosseguir",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Pix",
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)

            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(modifier = Modifier.fillMaxWidth())
            Column(modifier = Modifier.height(350.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "TOTAL A PAGAR: R$ 20,00", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(30.dp))
                Image(painter = painterResource(id = R.mipmap.pix), contentDescription = "pix", modifier = Modifier.size(150.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "OU", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.width(250.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF26212E))
                ) {
                    Text("COPIAR CÓDIGO PIX")
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
            ) {
                Text("Pagar ")
            }
        }


    }

}