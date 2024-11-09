package com.example.proyectofinal.presentation.screens.characterlist

import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.presentation.common.Action


sealed class CharacterListScreenAction: Action {
    data class OnFavCharacterClick(val favModel: FavModel) : CharacterListScreenAction()
    data object OnTryAgainClick : CharacterListScreenAction()
}
