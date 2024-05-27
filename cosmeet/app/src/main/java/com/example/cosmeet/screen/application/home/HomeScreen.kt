package com.example.cosmeet.screen.application.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.viewmodel.HomeViewModel
import com.google.gson.Gson

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
    var businessResponse by remember { mutableStateOf<BusinessResponse?>(null) }
    val allBusiness by homeViewModel.business.observeAsState(emptyList())

    LaunchedEffect(savedStateHandle) {
        savedStateHandle?.let {
            val jsonResponse = it.get<String>("BUSINESS")
            jsonResponse?.let { json ->
                businessResponse = Gson().fromJson(json, BusinessResponse::class.java)
                homeViewModel.getAllBusiness()
            }
        }
    }

    if (businessResponse != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 30.dp, end = 16.dp, bottom = 0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            HeaderSection(businessResponse!!, navController)
            Spacer(modifier = Modifier.height(30.dp))
            BusinessList(companies = allBusiness)
        }
    } else {
        Text("Carregando...")
    }
}

@Composable
fun HeaderSection(businessResponse: BusinessResponse, navController: NavHostController) {
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
                painter = rememberAsyncImagePainter(businessResponse.photo.toString()),
                contentDescription = "Imagem logo",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Olá, ${businessResponse.name}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 15.sp,
                    color = Color(0xFF252525)
                )
            )
        }

    }
    Spacer(modifier = Modifier.height(30.dp))
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
            modifier = Modifier
                .clickable(onClick = { navController.navigate("profile") })
                .padding(4.dp)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Divider(modifier = Modifier.fillMaxWidth())
}

@Composable
fun BusinessList(companies: List<BusinessResponse>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(companies) { company ->
            BusinessItem(company = company)
        }
    }
}

@Composable
fun BusinessItem(company: BusinessResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Name: ${company.name}")
        Text(text = "Description: ${company.about}")
    }
}
