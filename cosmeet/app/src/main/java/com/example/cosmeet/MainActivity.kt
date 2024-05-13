package com.example.cosmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosmeet.data.repository.cadastro.CadastroRepository
import com.example.cosmeet.data.repository.cadastro.network.CadastroService
import com.example.cosmeet.data.repository.login.LoginRepository
import com.example.cosmeet.data.repository.login.network.LoginService
import com.example.cosmeet.screen.SplashScreen
import com.example.cosmeet.screen.application.home.CompanyScreen
import com.example.cosmeet.screen.cadastro.CadastroScreen
import com.example.cosmeet.screen.cadastro.CadastroViewModel
import com.example.cosmeet.screen.login.LoginScreen
import com.example.cosmeet.screen.login.LoginViewModel
import com.example.cosmeet.screen.start.StartScreen
import com.example.cosmeet.ui.theme.CosmeetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "start") {
                composable("start") {
                    StartScreen(navController = navController)
                }

                composable("login") {
                    LoginScreen(
                        navController = navController,
                        loginViewModel = LoginViewModel(
                            LoginRepository(
                                LoginService()
                            )
                        )
                    )
                }

                composable("register") {
                    CadastroScreen(
                        navController = navController,
                        cadastroViewModel = CadastroViewModel(
                            CadastroRepository(
                                CadastroService()
                            )
                        )
                    )
                }

                composable("company/{companyName}") { backStackEntry ->
                    val companyName = backStackEntry.arguments?.getString("companyName")
                    CompanyScreen()
                }
            }
        }
    }
}
@Composable
fun Greeting() {
    Image(painter = painterResource(id = R.mipmap.pix), contentDescription = "pix" )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CosmeetTheme {
        Greeting()
    }
}