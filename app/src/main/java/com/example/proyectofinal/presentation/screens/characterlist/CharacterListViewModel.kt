package com.example.proyectofinal.presentation.screens.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.BaseViewModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val favUseCase: FavUseCase
    ): BaseViewModel() {

    private val _state = MutableLiveData(CharacterListState())
    val state: LiveData<CharacterListState> get() = _state

    init {
        getData()
    }

    override fun handleAction(action: Action) {
        when (action) {
            is CharacterListScreenAction.OnFavCharacterClick -> setFav(action.favModel)
            is CharacterListScreenAction.OnTryAgainClick -> tryAgain()
        }
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterList = getCharacterListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        characterUIState = ScreenUIState.Success,
                        characterList = characterList
                    )
                }
            } catch(exception: Exception) {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        characterUIState = ScreenUIState.Error(error = exception.message.orEmpty())
                    )
                }
            }
        }
    }

    private fun tryAgain() {
        _state.value = _state.value?.copy(
            characterUIState = ScreenUIState.Loading
        )
        getData()
    }

    private fun setFav(favModel: FavModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedList = _state.value?.characterList?.map { characterModel ->
                if (characterModel.id == favModel.id) {
                    println("PEDRO $characterModel")
                    characterModel.copy(favModel = favModel)
                } else {
                    characterModel
                }
            }

            withContext(Dispatchers.Main) {
                _state.value = _state.value?.copy(
                    characterList = updatedList ?: emptyList()
                )
            }

            favUseCase.invoke(favModel)
        }
    }

}
