package com.example.proyectofinal.presentation.screens.serielist

import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.State

data class SerieListState(
    val serieUIState: ScreenUIState = ScreenUIState.Loading,
    val serieList: List<SerieModel> = emptyList()
) : State
