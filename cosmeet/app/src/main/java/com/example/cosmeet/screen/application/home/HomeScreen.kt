package com.example.cosmeet.screen.application.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
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
import com.example.cosmeet.R
import com.example.cosmeet.ui.theme.CosmeetTheme
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
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 20.dp, bottom = 0.dp),
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
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF252525),
                                fontSize = 18.sp
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
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

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
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 16.sp
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Perfil",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val companiesInColumns = mockCompanies.chunked(2)
                items(companiesInColumns.size) { index ->
                    val columnCompanies = companiesInColumns[index]
                    Row(Modifier.fillMaxWidth()) {
                        columnCompanies.forEach { company ->
                            CompanyCard(company)
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

        }
    }
}


@Composable
fun CompanyCard(company: Company) {
    Card {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .width(120.dp)
        ) {
            Text(company.name, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(company.description)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHome() {
    CosmeetTheme {
        HomeScreen()
    }
}