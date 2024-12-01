package com.example.proyectofinal.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.common.Tab
import com.example.proyectofinal.presentation.common.extension.ZERO
import com.example.proyectofinal.presentation.screens.characterdetails.DetailScreen
import com.example.proyectofinal.presentation.screens.characterdetails.CharacterDetailState
import com.example.proyectofinal.presentation.screens.characterdetails.CharacterDetailViewModel
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
            tabCurrentIndex = Tab.Characters.index,
            onActions = { action ->
                characterListViewModel.handleAction(action)
            }
        )
    }
}

fun NavGraphBuilder.addDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.CharacterDetailScreen.route + "/{characterID}",
        arguments = Screen.CharacterDetailScreen.arguments
    ) { navBackStackEntry ->
        val characterDetailViewModel: CharacterDetailViewModel = koinViewModel()
        val state by characterDetailViewModel.state.observeAsState(CharacterDetailState())
        val idString = navBackStackEntry.arguments?.getString(CharacterArgs)
        DetailScreen(
            state = state,
            id = idString?.toIntOrNull() ?: Int.ZERO,
            onTabItem = { tabIndex ->
                tabNavigation(
                    navController = navController,
                    tabIndex = tabIndex
                )
            },
            tabCurrentIndex = TabCharacters,
            onActions = { action ->
                characterDetailViewModel.handleAction(action)
            }
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
            tabCurrentIndex = Tab.Comics.index,
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
            tabCurrentIndex = Tab.Series.index,
            onActions = { action ->
                serieListViewModel.handleAction(action)
            }
        )
    }
}

private fun tabNavigation(
    navController: NavHostController,
    tabIndex: Int
) = when (Tab.fromIndex(tabIndex)) {
    Tab.Characters -> navController.navigate(Screen.CharacterListScreen.route)
    Tab.Comics -> navController.navigate(Screen.ComicListScreen.route)
    Tab.Series -> navController.navigate(Screen.SerieListScreen.route)
    else -> {}
}

private const val CharacterArgs = "characterID"
