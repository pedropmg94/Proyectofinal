package com.example.proyectofinal.presentation.characterlist

import android.util.Log
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

    private val _ui = MutableLiveData<UILoginState>(UILoginState.Loading())
    val ui: LiveData<UILoginState> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterList = getCharacterListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = UILoginState.Loaded(items = characterList)
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _ui.value = UILoginState.Error(error = exception.message)
                }
            }
        }
    }

    fun retry() {
        _ui.value = UILoginState.Loading()
        getData()
    }

    fun setFav(favModel: FavModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val actualState = _ui.value as UILoginState.Loaded
            val list = actualState.items.toMutableList()
            list.forEachIndexed { index, characterModel ->
                characterModel.takeIf { it.id == favModel.id }?.let {
                    list[index] = it.copy(favModel = favModel)
                }
            }

            withContext(Dispatchers.Main) {
                _ui.value = UILoginState.Loaded(list)
            }

            favUseCase.invoke(favModel)
        }
    }

}

sealed class UILoginState() {
    class Loading(): UILoginState()
    class Loaded(val items: List<CharacterModel>): UILoginState()
    class Error(val error: String? = null): UILoginState()

}