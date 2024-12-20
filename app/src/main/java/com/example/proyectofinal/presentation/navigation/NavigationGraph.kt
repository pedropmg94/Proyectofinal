package com.example.proyectofinal.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
    navController = navController,
    startDestination = Screen.LoginScreen.route,
    ) {
        //Add the screen you want to navigate
        addLoginScreen(navController)
        addCharacterListScreen(navController)
        addCharacterDetailScreen(navController)
        addComicListScreen(navController)
        addSerieListScreen(navController)
    }
}