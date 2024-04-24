package com.example.cosmeet.screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cosmeet.ui.theme.CosmeetTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color

@Composable
fun SplashScreen(navController: NavHostController) {
    val animationProgress = animateFloatAsState(
        targetValue = 1f,
        animationSpec = TweenSpec(
            durationMillis = 1000,
            easing = LinearEasing
        )
    ).value

    Surface(color = Color(0xFF432D67)) { // Cor de fundo definida como 432D67
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Cosmeet",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                modifier = Modifier.alpha(animationProgress)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Juntos pela cosmética",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier
                    .alpha(animationProgress)
                    .padding(bottom = 10.dp)
            )

            Text(
                text = "Unidos pela conexão",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier
                    .alpha(animationProgress)
            )

            LaunchedEffect(key1 = animationProgress) {
                if (animationProgress == 1f) {
                    navController.navigate("login")
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    CosmeetTheme {
        SplashScreen(navController = navController)
    }
}