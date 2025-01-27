package com.minidahi.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.minidahi.presentation.screens.home.HomeScreen
import com.minidahi.presentation.screens.splash.SplashScreen
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.AgeGroup3To5.route) {
            // Geçici olarak boş bir ekran
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("3-5 Yaş Grubu")
            }
        }

        composable(Screen.AgeGroup6To8.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("6-8 Yaş Grubu")
            }
        }

        composable(Screen.AgeGroup9To10.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("9-10 Yaş Grubu")
            }
        }

        composable(Screen.ParentControl.route) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Ebeveyn Kontrol Paneli")
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    
    // Yaş gruplarına göre ekranlar
    object AgeGroup3To5 : Screen("age_3_5")
    object AgeGroup6To8 : Screen("age_6_8")
    object AgeGroup9To10 : Screen("age_9_10")
    
    // Ebeveyn kontrol paneli
    object ParentControl : Screen("parent_control")
} 