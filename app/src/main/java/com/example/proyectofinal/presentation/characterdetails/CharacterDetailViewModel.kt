package com.example.proyectofinal.presentation.characterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
): ViewModel() {

    private val _ui = MutableLiveData<CharacterModel>()
    val ui: LiveData<CharacterModel> get() = _ui

    fun getCharacter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterDetail = getCharacterDetailUseCase.invoke(id)
            withContext(Dispatchers.Main) {
                _ui.value = characterDetail
            }
        }
    }

}

data class CharacterDetailUI(val characterModel: CharacterModel)