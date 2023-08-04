package com.example.proyectofinal.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectofinal.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavHostController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen {
            navController.navigate(Screen.MovieListScreen.route)
        }
    }
}

fun NavGraphBuilder.addMovieListScreen(navController: NavHostController) {
    composable(Screen.MovieListScreen.route) {
        /*MovieListScreen {
            navController.navigate(Screen.MovieDetailScreen.route)
        }*/
    }
}

fun NavGraphBuilder.addMovieDetailScreen(navController: NavHostController) {
    composable(Screen.MovieDetailScreen.route) {
        /*Screen.MovieDetailScreen {
            navConoller.navigate(Screen.MovieDetailScreen.route) {
                MovieDetailsScreen()
            }
        }*/
    }
}