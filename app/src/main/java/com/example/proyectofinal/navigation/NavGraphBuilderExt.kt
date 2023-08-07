package com.example.proyectofinal.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.characterdetails.CharacterDetailScreen
import com.example.proyectofinal.presentation.characterlist.CharacterListScreen
import com.example.proyectofinal.presentation.components.HeaderTabLayout
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

fun NavGraphBuilder.addHeaderTab(navController: NavHostController) {
    composable(Screen.CharacterListScreen.route) {
        HeaderTabLayout(
            tabs = listOf("Personajes", "Comics", "Series", "Historias"),
            onTabSelected = { tabIndex ->
                val route = when (tabIndex) {
                    0 -> Screen.CharacterListScreen.route
                    1 -> Screen.ComicListScreen.route
                    2 -> Screen.SeriesListScreen.route
                    3 -> Screen.StoryListScreen.route
                    else -> Screen.CharacterListScreen.route
                }
                navController.navigate(route)
            }
        )
    }
}