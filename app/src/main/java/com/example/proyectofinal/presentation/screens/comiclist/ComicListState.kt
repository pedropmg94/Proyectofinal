package com.example.proyectofinal.presentation.screens.comiclist

import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.State

data class ComicListState(
    val comicUIState: ScreenUIState = ScreenUIState.Loading,
    val comicList: List<ComicModel> = emptyList()
) : State
