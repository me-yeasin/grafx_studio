package com.grafxstudio.grafx_studio.config.root_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grafxstudio.grafx_studio.config.root_navigation.screens.NavigationScreens
import com.grafxstudio.grafx_studio.features.home.screen.HomeScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.HomeScreen.name,
    ) {
        composable(NavigationScreens.HomeScreen.name) {
            HomeScreen(navController)
        }
    }
}