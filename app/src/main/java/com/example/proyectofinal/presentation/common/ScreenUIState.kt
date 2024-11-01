package com.example.proyectofinal.presentation.common

sealed class ScreenUIState<out T>: UIState {
    object Loading: ScreenUIState<Nothing>()
    data class Error(val error: String? = null) : ScreenUIState<Nothing>()
    data class Success<out T>(val data: T) : ScreenUIState<T>()
}

sealed class ScreenUIState2 : UIState {
    object Loading : ScreenUIState2()
    data class Error(val error: String = "Unknown error") : ScreenUIState2()
    object Success : ScreenUIState2()
}
