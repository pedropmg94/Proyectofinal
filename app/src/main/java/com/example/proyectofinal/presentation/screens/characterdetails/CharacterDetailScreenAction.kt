package com.example.proyectofinal.presentation.screens.characterdetails

import com.example.proyectofinal.presentation.common.Action

sealed class CharacterDetailScreenAction: Action {
    data class OnInitialize(val id: Int, val screen: Int) : CharacterDetailScreenAction()
    data class OnInitializeComic(val id: Int) : CharacterDetailScreenAction()
    data class OnInitializeSerie(val id: Int) : CharacterDetailScreenAction()
}
