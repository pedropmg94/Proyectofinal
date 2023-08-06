package com.example.proyectofinal.presentation.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<CharacterListUI>()
    val ui: LiveData<CharacterListUI> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            val characterList = getCharacterListUseCase.invoke()
            withContext(Dispatchers.Main) {
                _ui.value = CharacterListUI(items = characterList)
            }
        }
    }

}

data class CharacterListUI(val items: List<CharacterModel>)
