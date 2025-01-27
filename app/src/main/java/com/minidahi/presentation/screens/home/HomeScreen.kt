package com.minidahi.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.minidahi.presentation.main.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mini Dahi",
            style = MaterialTheme.typography.headlineLarge
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Yaş grupları butonları
        ElevatedButton(
            onClick = { navController.navigate(Screen.AgeGroup3To5.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("3-5 Yaş")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        ElevatedButton(
            onClick = { navController.navigate(Screen.AgeGroup6To8.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("6-8 Yaş")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        ElevatedButton(
            onClick = { navController.navigate(Screen.AgeGroup9To10.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("9-10 Yaş")
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Ebeveyn kontrol paneli butonu
        OutlinedButton(
            onClick = { navController.navigate(Screen.ParentControl.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ebeveyn Kontrol Paneli")
        }
    }
} 