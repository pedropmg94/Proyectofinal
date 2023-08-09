package com.example.proyectofinal.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(): ViewModel() {


    private val _ui = MutableLiveData<UILoginState>(UILoginState.Loaded())
    val ui: LiveData<UILoginState> get() = _ui

}

sealed class UILoginState() {
    class Loaded(): UILoginState()
}