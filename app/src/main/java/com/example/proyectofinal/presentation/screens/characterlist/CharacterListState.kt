package com.example.proyectofinal.presentation.screens.characterlist

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.State

data class CharacterListState(
    val characterUIState: ScreenUIState = ScreenUIState.Loading,
    val characterList: List<CharacterModel> = emptyList()
) : State
