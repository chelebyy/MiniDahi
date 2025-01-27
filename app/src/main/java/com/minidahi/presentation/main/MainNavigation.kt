package com.minidahi.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.minidahi.presentation.screens.home.HomeScreen
import com.minidahi.presentation.screens.splash.SplashScreen

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