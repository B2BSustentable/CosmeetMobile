package com.example.cosmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosmeet.screen.application.home.HomeScreen
import com.example.cosmeet.screen.application.perfil.EditProfile
import com.example.cosmeet.screen.application.perfil.PerfilScreen
import com.example.cosmeet.screen.cadastro.CadastroScreen
import com.example.cosmeet.screen.cadastro.SecondStepRegister
import com.example.cosmeet.screen.login.LoginScreen
import com.example.cosmeet.viewmodel.LoginViewModel
import com.example.cosmeet.screen.start.StartScreen
import com.example.cosmeet.ui.theme.CosmeetTheme
import com.example.cosmeet.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CosmeetTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") {
                        StartScreen(navController = navController)
                    }
                    composable("login") {
                        LoginScreen(
                            navController = navController,
                            loginViewModel = LoginViewModel()
                        )
                    }
                    composable("register") {
                        CadastroScreen(
                            navController = navController
                        )
                    }
                    composable("firstStepRegister") {
                        CadastroScreen(
                            navController = navController
                        )
                    }
                    composable("secondStepRegister") {
                        SecondStepRegister(
                            navController = navController
                        )
                    }
                    composable("home") {
                        HomeScreen(
                            navController = navController,
                            homeViewModel = HomeViewModel()
                        )
                    }
                    composable("profile") {
                        PerfilScreen(
                            navController = navController
                        )
                    }
                    composable("editProfile") {
                        EditProfile(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CosmeetTheme {
        Greeting()
    }
}
