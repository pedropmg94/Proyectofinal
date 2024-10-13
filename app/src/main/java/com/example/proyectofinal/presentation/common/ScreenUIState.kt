package com.example.proyectofinal.presentation.common

sealed class ScreenUIState<out T>: UIState {
    object Loading: ScreenUIState<Nothing>()
    data class Error(val error: String? = null) : ScreenUIState<Nothing>()
    data class Success<out T>(val data: T) : ScreenUIState<T>()
}
