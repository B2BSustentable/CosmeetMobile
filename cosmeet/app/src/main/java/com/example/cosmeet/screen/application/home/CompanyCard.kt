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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cosmeet.R
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun CompanyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.width(500.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                contentDescription = "oBoticário Logo",
                painter = painterResource(id = R.mipmap.iconteste),
            )
            Column {
                Text(
                    text = "oBoticario",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Distribuidor", style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Guarulhos, São Paulo, Brasil",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column {
                Image(
                    modifier = Modifier
                        .size(30.dp),
                    contentDescription = "oBoticário Logo",
                    painter = painterResource(id = R.mipmap.iconteste),
                )
                Image(
                    modifier = Modifier
                        .size(30.dp),
                    contentDescription = "oBoticário Logo",
                    painter = painterResource(id = R.mipmap.iconteste),
                )
            }
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Column {


            Text(
                text = "Contatos", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )

            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "telefone: 1197298-1912")
            }

            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "e-mail: diegovieirawork@gmail.com")
            }

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            Text(
                text = "Sobre", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = "Há dois anos, a NIVEA continuou sua longa jornada de cuidado e beleza, trazendo inovação e qualidade incomparáveis para o mundo da cosmética. Hoje, celebramos com orgulho nosso aniversário de dois anos como uma marca que conquistou a confiança de milhões de pessoas em todo o mundo",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCard() {
    CosmeetTheme {
        CompanyScreen()
    }
}
