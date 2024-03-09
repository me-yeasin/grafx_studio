package com.grafxstudio.grafx_studio.config.root_navigation.screens

enum class NavigationScreens {
    HomeScreen;

    companion object {
        fun fromRoute(route: String?) : NavigationScreens
        = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("route $route not supported")
        }
    }
}