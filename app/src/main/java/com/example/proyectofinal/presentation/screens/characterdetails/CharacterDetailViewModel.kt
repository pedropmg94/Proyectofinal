package com.example.proyectofinal.presentation.screens.characterdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.usecase.GetCharacterDetailUseCase
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.BaseViewModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
): BaseViewModel() {

    private val _state = MutableLiveData(CharacterDetailState())
    val state: LiveData<CharacterDetailState> get() = _state

    override fun handleAction(action: Action) {
        when (action) {
            is CharacterDetailScreenAction.OnInitializeCharacter -> getCharacter(action.id)
            is CharacterDetailScreenAction.OnInitializeComic -> getCharacter(action.id)
            is CharacterDetailScreenAction.OnInitializeSerie -> getCharacter(action.id)
        }
    }

    private fun getCharacter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterDetail = getCharacterDetailUseCase.invoke(id)
            withContext(Dispatchers.Main) {
                _state.value = _state.value?.copy(
                    characterDetailUIState = ScreenUIState2.Success,
                    id = characterDetail.id,
                    name = characterDetail.name,
                    description = characterDetail.description,
                    photoURL = characterDetail.photoURL
                )
            }
        }
    }

    private fun getComic(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterDetail = getCharacterDetailUseCase.invoke(id)
            withContext(Dispatchers.Main) {
                _state.value = _state.value?.copy(
                    characterDetailUIState = ScreenUIState2.Success,
                    id = characterDetail.id,
                    name = characterDetail.name,
                    description = characterDetail.description,
                    photoURL = characterDetail.photoURL
                )
            }
        }
    }

    private fun getSerie(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterDetail = getCharacterDetailUseCase.invoke(id)
            withContext(Dispatchers.Main) {
                _state.value = _state.value?.copy(
                    characterDetailUIState = ScreenUIState2.Success,
                    id = characterDetail.id,
                    name = characterDetail.name,
                    description = characterDetail.description,
                    photoURL = characterDetail.photoURL
                )
            }
        }
    }
}
