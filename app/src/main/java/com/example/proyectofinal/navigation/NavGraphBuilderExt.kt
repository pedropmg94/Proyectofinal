package com.example.proyectofinal.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.characterdetails.CharacterDetailScreen
import com.example.proyectofinal.presentation.characterlist.CharacterListScreen
import com.example.proyectofinal.presentation.comiclist.ComicListScreen
import com.example.proyectofinal.presentation.login.LoginScreen
import com.example.proyectofinal.presentation.serielist.SerieListScreen

fun NavGraphBuilder.addLoginScreen(navController: NavHostController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(
            onLoginSuccess = {
                navController.navigate(Screen.CharacterListScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addCharacterListScreen(navController: NavHostController) {
    composable(Screen.CharacterListScreen.route) {
        CharacterListScreen(
            onItemClick = { characterID ->
                navController.navigate("${Screen.CharacterDetailScreen.route}/$characterID")
            },
            onTabItem = { tabIndex ->
                when (tabIndex) {
                    0 -> navController.navigate(Screen.CharacterListScreen.route)
                    1 -> navController.navigate(Screen.ComicListScreen.route)
                    2 -> navController.navigate(Screen.SerieListScreen.route)
                }
            }
        )
    }
}

fun NavGraphBuilder.addCharacterDetailScreen() {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterID}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) { navBackStackEntry ->
        val idString = navBackStackEntry.arguments?.getString("characterID")
        val id = idString?.toIntOrNull() ?: 0
        CharacterDetailScreen(id = id)
    }
}

fun NavGraphBuilder.addComicListScreen(navController: NavHostController) {
    composable(Screen.ComicListScreen.route) {
        ComicListScreen(
            onTabItem = { tabIndex ->
                when (tabIndex) {
                    0 -> navController.navigate(Screen.CharacterListScreen.route)
                    1 -> navController.navigate(Screen.ComicListScreen.route)
                    2 -> navController.navigate(Screen.SerieListScreen.route)
                }
            }
        )
    }
}

fun NavGraphBuilder.addSerieListScreen(navController: NavHostController) {
    composable(Screen.SerieListScreen.route) {
        SerieListScreen(
            onTabItem = { tabIndex ->
                when (tabIndex) {
                    0 -> navController.navigate(Screen.CharacterListScreen.route)
                    1 -> navController.navigate(Screen.ComicListScreen.route)
                    2 -> navController.navigate(Screen.SerieListScreen.route)
                }
            }
        )
    }
}
