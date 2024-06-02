package com.example.cosmeet.screen.application.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cosmeet.domain.UserPreferences
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.viewmodel.HomeViewModel
import com.example.cosmeet.viewmodel.LoginViewModel
import com.google.gson.Gson

data class Company(val id: Long, val name: String, val description: String)

val mockCompanies = listOf(
    Company(id = 1, name = "Nivea", description = "Nivea"),
    Company(id = 1, name = "Nivea2", description = "Nivea"),
    Company(id = 1, name = "Nivea3", description = "Nivea"),
    Company(id = 1, name = "Nivea4", description = "Nivea"),
    Company(id = 1, name = "Nivea5", description = "Nivea"),
    Company(id = 1, name = "Nivea6", description = "Nivea"),
    Company(id = 1, name = "Nivea7", description = "Nivea"),
)

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel(),
) {
    val context = LocalContext.current
    var businessResponse by remember { mutableStateOf<BusinessResponse?>(null) }
    val allBusiness by homeViewModel._business.observeAsState()

    homeViewModel.getAllBusiness()

    LaunchedEffect(Unit) {
        UserPreferences.getUser(context).collect { savedBusinessResponse ->
            businessResponse = savedBusinessResponse
            Log.d("business", businessResponse.toString())
        }
    }

    LaunchedEffect(allBusiness) {
        allBusiness?.let {
            Log.d("response**23", it.toString())
        } ?: Log.d("response**23", "allBusiness is null")
    }

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
                    painter = rememberAsyncImagePainter(businessResponse?.photo.toString()),
                    contentDescription = "logo da empresa",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Olá, ${businessResponse?.name.toString()}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 15.sp,
                        color = Color(0xFF252525)
                    )
                )
            }
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
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Perfil",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable(onClick = { navController.navigate("profile") }).padding(4.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(15.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                content = {
                    items(allBusiness?.size ?: 0) { index ->
                        val company = allBusiness?.get(index)
                        Column {
                            CompanyCard(company, navController) {}
                            Spacer(modifier = Modifier.height(10.dp))
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyCard(company: BusinessResponse?, navController: NavHostController, onClick: () -> Unit) {
    Log.d("COMPANYCARD", company.toString())
    Log.d("COMPANYCARDuserID", company?.user?.id.toString())
    Card(
        onClick = { navController.navigate("companyScreen/${company?.user?.id.toString()}") }
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .width(130.dp)
        ) {
            Text(company?.name.toString(), style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(50.dp))
            Text(company?.about.toString())
        }
    }
}
