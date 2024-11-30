package com.example.proyectofinal.presentation.screens.comiclist

import com.example.proyectofinal.presentation.common.Action

sealed class ComicListScreenAction: Action {
    data object OnTryAgainClick : ComicListScreenAction()
}
