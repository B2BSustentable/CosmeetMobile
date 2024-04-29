package com.example.cosmeet.screen.cadastro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cosmeet.ui.theme.CosmeetTheme


@Composable
fun PlanoSelecaoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Básico",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Common",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Premium",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Divider(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(30.dp))


            Spacer(modifier = Modifier.height(8.dp))

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
                    style = MaterialTheme.typography.bodyMedium
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
                    text = "Consulta Ilimitadas:",
                    style = MaterialTheme.typography.bodyMedium
                )

                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Consulta ilimitadas"
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
                    style = MaterialTheme.typography.bodyMedium
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
                text = "R$ 20,00",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )}
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
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPlano() {
    CosmeetTheme {
        PlanoSelecaoScreen()
    }
}