package com.example.proyectofinal.presentation.common

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun handleAction(action: Action)
}