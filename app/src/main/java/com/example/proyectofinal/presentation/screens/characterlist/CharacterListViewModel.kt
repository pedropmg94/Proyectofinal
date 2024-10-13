package com.example.proyectofinal.presentation.screens.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import com.example.proyectofinal.presentation.common.ScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val favUseCase: FavUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<ScreenUIState<List<CharacterModel>>>(ScreenUIState.Loading)
    val ui: LiveData<ScreenUIState<List<CharacterModel>>> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterList = getCharacterListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = ScreenUIState.Success(data = characterList)
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _ui.value = ScreenUIState.Error(error = exception.message)
                }
            }
        }
    }

    fun retryCharacter() {
        _ui.value = ScreenUIState.Loading
        getData()
    }

    fun setFav(favModel: FavModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val actualState = _ui.value as ScreenUIState.Success
            val list = actualState.data.toMutableList()
            list.forEachIndexed { index, characterModel ->
                characterModel.takeIf { it.id == favModel.id }?.let {
                    list[index] = it.copy(favModel = favModel)
                }
            }

            withContext(Dispatchers.Main) {
                _ui.value = ScreenUIState.Success(list)
            }

            favUseCase.invoke(favModel)
        }
    }

}
