package com.example.proyectofinal.presentation.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<MovieListUI>()
    val ui: LiveData<MovieListUI> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            getCharacterListUseCase.invoke()
        }
    }

}

data class MovieListUI(val items: List<CharacterModel>)
