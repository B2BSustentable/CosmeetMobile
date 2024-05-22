package com.example.cosmeet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cosmeet.data.repository.cadastro.CadastroRepository
import com.example.cosmeet.data.repository.cadastro.network.CadastroService
import com.example.cosmeet.data.repository.login.LoginRepository
import com.example.cosmeet.data.repository.login.network.LoginService
import com.example.cosmeet.screen.application.home.HomeScreen
import com.example.cosmeet.screen.application.perfil.EditProfile
import com.example.cosmeet.screen.application.perfil.PerfilScreen
import com.example.cosmeet.screen.cadastro.CadastroScreen
import com.example.cosmeet.screen.cadastro.CadastroViewModel
import com.example.cosmeet.screen.cadastro.SecondStepRegister
import com.example.cosmeet.screen.login.LoginScreen
import com.example.cosmeet.screen.login.LoginViewModel
import com.example.cosmeet.screen.start.StartScreen
import com.example.cosmeet.ui.theme.CosmeetTheme

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
                    composable("firstStepRegister") {
                        CadastroScreen(
                            navController = navController, cadastroViewModel = CadastroViewModel(
                                CadastroRepository(
                                    CadastroService()
                                )
                            )
                        )
                    }
                    composable("secondStepRegister") {
                        SecondStepRegister(
                            navController = navController,
                            cadastroViewModel = CadastroViewModel(
                                CadastroRepository(
                                    CadastroService()
                                )
                            )
                        )
                    }
                    composable("home") {
                        HomeScreen(
                            navController = navController
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
