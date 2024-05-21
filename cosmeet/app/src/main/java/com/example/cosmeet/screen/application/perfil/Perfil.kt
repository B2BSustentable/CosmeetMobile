package com.example.cosmeet.screen.application.perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cosmeet.R
import com.example.cosmeet.screen.application.home.HomeScreen
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun PerfilScreen(navController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp, end = 16.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.iconteste),
                    contentDescription = "logo da empresa",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF252525),
                                fontSize = 15.sp
                            )
                        ) {
                            append("Olá, Nivea")
                        }
                    }
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.fav),
                contentDescription = "favoritos",
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.width(250.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 16.sp,
                    ),
                    modifier = Modifier.clickable(onClick = { navController.navigate("home") }).padding(4.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Perfil",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Image(
                        painter = painterResource(id = R.mipmap.iconteste),
                        contentDescription = "logo da empresa",
                        modifier = Modifier.size(60.dp)
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Text(text = "NIVEA LTDA")
                        Text(text = "Distribuidor")
                        Text(text = "Guarulhos, São Paulo")
                        }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Column {
                    Text(text =
                            "Há dois anos, a NIVEA continuou sua longa jornada de cuidado e beleza, trazendo inovação e qualidade incomparáveis para o mundo da cosmética. Hoje, celebramos com orgulho nosso aniversário de dois anos como uma marca que conquistou a confiança de milhões de pessoas em todo o mundo.\n" +
                            "Nossa Missão de Cuidado e Beleza\n" +
                            "Desde o início, a NIVEA se comprometeu a promover a beleza autêntica e o bem-estar de nossos clientes. Estamos empenhados em cuidar de sua pele e fornecer produtos de alta qualidade que a mantenham saudável e radiante [...]", fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(25.dp))
                Button(onClick = {navController.navigate("editProfile") },  colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                ) {
                    Text(text = "Editar Perfil", color = Color.White)
                }
                Spacer(modifier = Modifier.height(50.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "BÁSICO", fontWeight = FontWeight.Bold)
                    Button(onClick = { navController.navigate("edit") }, colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
                    ) {
                        Text("Trocar plano", color = Color.White)
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewPerfil() {
//    CosmeetTheme {
//        PerfilScreen()
//    }
//}