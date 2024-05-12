package com.example.cosmeet.screen.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cosmeet.R
import com.example.cosmeet.screen.cadastro.PagamentoScreen
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun StartScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.mipmap.photo1),
            contentDescription = "logo",
            modifier = Modifier.size(430.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally ) {
            Text(
                text = "Amplie suas conexões",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "LOrem impsum asdkasdkas okasdpoas ksdm fkad",
                textAlign = TextAlign.Center, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF432D67))
            ) {
                Text("Crie sua conta")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Já possuo uma conta", fontSize = 13.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStart() {
    CosmeetTheme {
        StartScreen()
    }
}