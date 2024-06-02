package com.example.cosmeet.screen.application.perfil

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cosmeet.R
import com.example.cosmeet.domain.UserPreferences
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun EditProfile(navController: NavHostController) {
    val context = LocalContext.current
    var businessResponse by remember { mutableStateOf<BusinessResponse?>(null) }

    val occupation = remember { mutableStateOf("") }
    var nome = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        UserPreferences.getUser(context).collect { savedBusinessResponse ->
            businessResponse = savedBusinessResponse
            nome = mutableStateOf(businessResponse?.name.toString())
            Log.d("name", nome.toString())
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp, end = 16.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                Surface(
                    color = Color.White,
                    shadowElevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(640.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 20.dp, end = 15.dp, bottom = 0.dp)
                            .verticalScroll(state = rememberScrollState()),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Informações Gerais")
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "back"
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(bottom = 16.dp),
                                contentDescription = "Editar Foto",
                                painter = painterResource(id = R.mipmap.editimg),
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Column {
                                OutlinedTextField(
                                    value = nome.value,
                                    onValueChange = { nome.value = it },
                                    label = { Text("Nome Empresa") },
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                OutlinedTextField(
                                    value = occupation.value,
                                    onValueChange = { occupation.value = it },
                                    label = { Text("Área de atuação") },
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        Divider(modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.height(20.dp))

                        Column {
                            Text(text = "Endereço")
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = "03450010",
                                onValueChange = {},
                                label = { Text("CEP") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = "Distribuidor",
                                onValueChange = {},
                                label = { Text("Cidade") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = "Carrão",
                                onValueChange = {},
                                label = { Text("Bairro") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Row() {
                                OutlinedTextField(
                                    value = "Cururipe",
                                    onValueChange = {},
                                    label = { Text("Rua") },
                                    modifier = Modifier.width(130.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))
                                OutlinedTextField(
                                    value = "144",
                                    onValueChange = {},
                                    label = { Text("Número") },
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Divider(modifier = Modifier.fillMaxWidth())
                            Spacer(modifier = Modifier.height(20.dp))

                            Column {
                                Text(text = "Informações Sobre A Empresa")
                                Spacer(modifier = Modifier.height(20.dp))

                                BasicTextField(
                                    value = "Descrição sobre a empresa...",
                                    onValueChange = {},
                                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                                    singleLine = false,
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        imeAction = ImeAction.Done,
                                        keyboardType = KeyboardType.Text
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                    ) {
                        Text("Salvar", color = Color.White)
                    }
                }
            }
        }
    }
}

