package com.example.proyectofinal.presentation.screens.characterdetails

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.State
import com.example.proyectofinal.presentation.common.extension.EMPTY_STRING
import com.example.proyectofinal.presentation.common.extension.ZERO

data class CharacterDetailState(
    val characterDetailUIState: ScreenUIState2 = ScreenUIState2.Loading,
    val characterDetail: CharacterModel =
        CharacterModel(
            id = Int.ZERO,
            name = String.EMPTY_STRING,
            description = String.EMPTY_STRING,
            photoURL = String.EMPTY_STRING,
            favModel = FavModel(
                id = Int.ZERO,
                favorite = false
            )
        )
) : State
