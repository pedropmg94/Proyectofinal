package com.example.proyectofinal.presentation.screens.characterdetails

import com.example.proyectofinal.presentation.common.Action

sealed class CharacterDetailScreenAction: Action {
    data class OnInitialize(val id: Int) : CharacterDetailScreenAction()
}
