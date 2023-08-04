package com.example.proyectofinal.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object LoginScreen: Screen(
        route = "login",
        arguments = emptyList()
    )

    object MovieListScreen: Screen(
        route = "movieList",
        arguments = emptyList()
    )

    object MovieDetailScreen: Screen(
        route = "movieDetail",
        arguments = emptyList()
    )

}