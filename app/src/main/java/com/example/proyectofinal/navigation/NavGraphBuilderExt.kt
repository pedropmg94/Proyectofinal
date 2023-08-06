package com.example.proyectofinal.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.characterdetails.CharacterDetailScreen
import com.example.proyectofinal.presentation.characterlist.CharacterListScreen
import com.example.proyectofinal.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavHostController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen (
            onLoginSuccess = {
                navController.navigate(Screen.CharacterListScreen.route)
            }
                )
    }
}

fun NavGraphBuilder.addCharacterListScreen(navController: NavHostController) {
    composable(Screen.CharacterListScreen.route) {
        CharacterListScreen {characterID ->
            navController.navigate("${Screen.CharacterDetailScreen.route}/$characterID")
        }
    }
}

fun NavGraphBuilder.addCharacterDetailScreen() {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterID}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) {navBackStackEntry ->
        val idString = navBackStackEntry.arguments?.getString("characterID")
        val id = idString?.toIntOrNull() ?: 0
        CharacterDetailScreen(id = id)
    }
}