package com.example.proyectofinal.presentation.common

sealed class ScreenUIState : UIState {
    data object Loading : ScreenUIState()
    data class Error(val error: String = "Unknown error") : ScreenUIState()
    data object Success : ScreenUIState()
}
