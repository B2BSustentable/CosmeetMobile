package com.example.cosmeet.screen.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cosmeet.screen.login.LoginScreen
import com.example.cosmeet.ui.theme.CosmeetTheme

@Composable
fun HomeScreen() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPlano() {
    CosmeetTheme {
        HomeScreen()
    }
}