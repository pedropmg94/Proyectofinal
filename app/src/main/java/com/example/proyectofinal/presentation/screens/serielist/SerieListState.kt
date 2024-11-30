package com.example.proyectofinal.presentation.screens.serielist

import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.State

data class SerieListState(
    val serieUIState: ScreenUIState2 = ScreenUIState2.Loading,
    val serieList: List<SerieModel> = emptyList()
) : State
