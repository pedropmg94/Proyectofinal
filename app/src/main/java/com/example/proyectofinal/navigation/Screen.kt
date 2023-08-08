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

    object CharacterListScreen: Screen(
        route = "characterList",
        arguments = emptyList()
    )

    object CharacterDetailScreen: Screen(
        route = "characterDetail",
        arguments = emptyList()
    )

    object ComicListScreen: Screen(
        route = "comicList",
        arguments = emptyList()
    )

    object SerieListScreen: Screen(
        route = "serieList",
        arguments = emptyList()
    )

}