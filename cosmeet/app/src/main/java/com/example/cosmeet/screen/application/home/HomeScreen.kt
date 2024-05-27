package com.example.cosmeet.screen.application.home

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cosmeet.R
import com.example.cosmeet.domain.dto.BusinessResponse
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import coil.compose.rememberAsyncImagePainter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

data class Company(val name: String, val description: String)

val mockCompanies = listOf(
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea"),
    Company(name = "Nivea", description = "Nivea")
)

@Composable
fun HomeScreen(navController : NavHostController) {
    val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
    var businessResponse by remember { mutableStateOf<BusinessResponse?>(null) }

    LaunchedEffect(savedStateHandle) {
        val jsonString = savedStateHandle?.get<String>("LOGIN_RESPONSE")
        jsonString?.let {
            val response = Json.decodeFromString<BusinessResponse>(it)
            businessResponse = response
        }
    }

    businessResponse?.let { response ->
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
                        painter = rememberAsyncImagePainter(response.photo),
                        contentDescription = "Imagem logo",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Olá, " + response.name,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 15.sp,
                            color = Color(0xFF252525)
                        )
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
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 16.sp
                        ),
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Perfil",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .clickable(onClick = { navController.navigate("profile") })
                            .padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Divider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(15.dp))

                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        items(mockCompanies.size) { index ->
                            val company = mockCompanies[index]
                            Column {
                                CompanyCard(company) {}
                                Spacer(modifier = Modifier.height(10.dp))
                                Spacer(modifier = Modifier.width(16.dp))
                            }
                        }
                    }
                )
            }
        }
    } ?: run {
        // Exibição alternativa enquanto businessResponse é nulo
        Text("Carregando...")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyCard(company: Company, onClick: () -> Unit) {
    Card(
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .width(130.dp)
        ) {
            Text(company.name, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(50.dp))
            Text(company.description)
        }
    }
}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewHome() {
//    CosmeetTheme {
//        HomeScreen()
//    }
//}