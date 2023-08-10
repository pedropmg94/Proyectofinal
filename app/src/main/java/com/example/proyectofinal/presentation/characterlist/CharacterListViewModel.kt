package com.example.proyectofinal.presentation.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val favUseCase: FavUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<UICharacterListState>(UICharacterListState.Loading())
    val ui: LiveData<UICharacterListState> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterList = getCharacterListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = UICharacterListState.Loaded(items = characterList)
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _ui.value = UICharacterListState.Error(error = exception.message)
                }
            }
        }
    }

    fun retryCharacter() {
        _ui.value = UICharacterListState.Loading()
        getData()
    }

    fun setFav(favModel: FavModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val actualState = _ui.value as UICharacterListState.Loaded
            val list = actualState.items.toMutableList()
            list.forEachIndexed { index, characterModel ->
                characterModel.takeIf { it.id == favModel.id }?.let {
                    list[index] = it.copy(favModel = favModel)
                }
            }

            withContext(Dispatchers.Main) {
                _ui.value = UICharacterListState.Loaded(list)
            }

            favUseCase.invoke(favModel)
        }
    }

}

sealed class UICharacterListState() {
    class Loading(): UICharacterListState()
    class Loaded(val items: List<CharacterModel>): UICharacterListState()
    class Error(val error: String? = null): UICharacterListState()

}