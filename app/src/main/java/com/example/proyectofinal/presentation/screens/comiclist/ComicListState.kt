package com.example.proyectofinal.presentation.screens.comiclist

import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.State

data class ComicListState(
    val comicUIState: ScreenUIState2 = ScreenUIState2.Loading,
    val comicList: List<ComicModel> = emptyList()
) : State
