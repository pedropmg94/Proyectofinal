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
import com.example.proyectofinal.presentation.screens.comiclist.ComicListState
import com.example.proyectofinal.presentation.screens.comiclist.ComicListViewModel
import com.example.proyectofinal.presentation.screens.login.LoginScreen
import com.example.proyectofinal.presentation.screens.serielist.SerieListScreen
import com.example.proyectofinal.presentation.screens.serielist.SerieListState
import com.example.proyectofinal.presentation.screens.serielist.SerieListViewModel
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
                tabNavigation(
                    navController = navController,
                    tabIndex = tabIndex
                )
            },
            tabCurrentIndex = TabCharacters,
            onActions = { action ->
                characterListViewModel.handleAction(action)
            }
        )
    }
}

fun NavGraphBuilder.addCharacterDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterID}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) { navBackStackEntry ->
        val idString = navBackStackEntry.arguments?.getString("characterID")
        val id = idString?.toIntOrNull() ?: 0
        CharacterDetailScreen(
            id = id,
            onTabItem = { tabIndex ->
                tabNavigation(
                    navController = navController,
                    tabIndex = tabIndex
                )
            },
            tabCurrentIndex = TabCharacters
        )
    }
}

fun NavGraphBuilder.addComicListScreen(navController: NavHostController) {
    composable(Screen.ComicListScreen.route) {
        val comicListViewModel: ComicListViewModel = koinViewModel()
        val state by comicListViewModel.state.observeAsState(ComicListState())

        ComicListScreen(
            state = state,
            onTabItem = { tabIndex ->
                tabNavigation(
                    navController = navController,
                    tabIndex = tabIndex
                )
            },
            tabCurrentIndex = TabComics,
            onActions = { action ->
                comicListViewModel.handleAction(action)
            }
        )
    }
}

fun NavGraphBuilder.addSerieListScreen(navController: NavHostController) {
    composable(Screen.SerieListScreen.route) {
        val serieListViewModel: SerieListViewModel = koinViewModel()
        val state by serieListViewModel.state.observeAsState(SerieListState())

        SerieListScreen(
            state = state,
            onTabItem = { tabIndex ->
                tabNavigation(
                    navController = navController,
                    tabIndex = tabIndex
                )
            },
            tabCurrentIndex = TabSeries,
            onActions = { action ->
                serieListViewModel.handleAction(action)
            }
        )
    }
}

private fun tabNavigation(
    navController: NavHostController,
    tabIndex: Int
) = when (tabIndex) {
    TabCharacters -> navController.navigate(Screen.CharacterListScreen.route)
    TabComics -> navController.navigate(Screen.ComicListScreen.route)
    TabSeries -> navController.navigate(Screen.SerieListScreen.route)
    else -> {}
}

private const val TabCharacters = 0
private const val TabComics = 1
private const val TabSeries = 2
