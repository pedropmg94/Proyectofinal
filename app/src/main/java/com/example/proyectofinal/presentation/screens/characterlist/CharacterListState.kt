package com.example.proyectofinal.presentation.screens.characterlist

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.State

data class CharacterListState(
    val characterUIState: ScreenUIState2 = ScreenUIState2.Loading,
    val characterList: List<CharacterModel> = emptyList()
) : State
