package com.example.cosmeet.screen.application.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cosmeet.R
import com.example.cosmeet.domain.UserPreferences
import com.example.cosmeet.domain.dto.BusinessResponse
import com.example.cosmeet.ui.theme.CosmeetTheme
import com.example.cosmeet.viewmodel.CompanyProfileViewModel

@Composable
fun CompanyScreen(
    navController: NavHostController,
    id: String?,
    companyProfileViewModel: CompanyProfileViewModel = viewModel(),
) {
    val context = LocalContext.current
    var businessResponse by remember { mutableStateOf<BusinessResponse?>(null) }
    val oneBusiness by companyProfileViewModel.business.observeAsState()

    LaunchedEffect(Unit) {
        UserPreferences.getUser(context).collect { savedBusinessResponse ->
            Log.d("iddobusines", id.toString())
            companyProfileViewModel.fetchBusinessById(id?.toLong())
            businessResponse = savedBusinessResponse
        }
    }

    LaunchedEffect(oneBusiness) {
        oneBusiness?.let {
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
                    text = "Olá, ${businessResponse?.name}",
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
            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(30.dp))

            Surface(
                color = Color.White,
                shadowElevation = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, top = 20.dp, end = 15.dp, bottom = 0.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            modifier = Modifier
                                .size(80.dp)
                                .padding(bottom = 16.dp),
                            contentDescription = "oBoticário Logo",
                            painter = rememberAsyncImagePainter(oneBusiness?.photo.toString()),
                        )
                        Column(modifier = Modifier.width(140.dp)) {
                            Text(
                                text = oneBusiness?.name.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = oneBusiness?.occupation.toString(),
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Text(
                                text = oneBusiness?.address?.neighborhood.toString()
                                        + ", " + oneBusiness?.address?.city.toString(),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(modifier = Modifier.width(70.dp))
                        Column {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "close icon",
                                modifier = Modifier.clickable(
                                    onClick = {
                                        navController.navigate("home")
                                    }
                                )
                            )
                            Spacer(modifier = Modifier.height(30.dp))

                        }
                    }

                    Divider(modifier = Modifier.padding(vertical = 16.dp))

                    Column {
                        Text(
                            text = "Contatos",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )

                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "telefone: ${oneBusiness?.phone.toString()}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "e-mail: ${oneBusiness?.email.toString()}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Divider(modifier = Modifier.padding(vertical = 16.dp))

                        Text(
                            text = "Sobre",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )

                        Text(
                            text = oneBusiness?.about.toString(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
