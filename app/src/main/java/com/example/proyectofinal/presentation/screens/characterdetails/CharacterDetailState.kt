package com.example.proyectofinal.presentation.screens.characterdetails

import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.State
import com.example.proyectofinal.presentation.common.extension.EMPTY_STRING
import com.example.proyectofinal.presentation.common.extension.ZERO

data class CharacterDetailState(
    val characterDetailUIState: ScreenUIState2 = ScreenUIState2.Loading,
    val id: Int = Int.ZERO,
    val name: String = String.EMPTY_STRING,
    val description: String = String.EMPTY_STRING,
    val photoURL: String = String.EMPTY_STRING
) : State
