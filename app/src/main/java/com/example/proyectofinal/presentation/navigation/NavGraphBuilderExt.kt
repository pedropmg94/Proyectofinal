package com.example.proyectofinal.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.screens.characterdetails.CharacterDetailScreen
import com.example.proyectofinal.presentation.screens.characterlist.CharacterListScreen
import com.example.proyectofinal.presentation.screens.characterlist.CharacterListState
import com.example.proyectofinal.presentation.screens.characterlist.CharacterListViewModel
import com.example.proyectofinal.presentation.screens.comiclist.ComicListScreen
import com.example.proyectofinal.presentation.screens.login.LoginScreen
import com.example.proyectofinal.presentation.screens.serielist.SerieListScreen
import org.koin.androidx.compose.koinViewModel

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
        val characterListViewModel: CharacterListViewModel = koinViewModel()
        val state by characterListViewModel.state.observeAsState(CharacterListState())

        CharacterListScreen(
            state = state,
            onItemClick = { characterID ->
                navController.navigate("${Screen.CharacterDetailScreen.route}/$characterID")
            },
            onTabItem = { tabIndex ->
                when (tabIndex) {
                    0 -> navController.navigate(Screen.CharacterListScreen.route)
                    1 -> navController.navigate(Screen.ComicListScreen.route)
                    2 -> navController.navigate(Screen.SerieListScreen.route)
                }
            },
            onActions = { action ->
                characterListViewModel.handleAction(action)
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
