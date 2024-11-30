package com.example.proyectofinal.presentation.screens.serielist

import com.example.proyectofinal.presentation.common.Action

sealed class SerieListScreenAction: Action {
    data object OnTryAgainClick : SerieListScreenAction()
}
