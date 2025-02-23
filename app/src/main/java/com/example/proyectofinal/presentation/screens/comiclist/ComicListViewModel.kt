package com.example.proyectofinal.presentation.screens.comiclist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.usecase.ComicsUseCase
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.BaseViewModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicListViewModel(
    private val comicsUseCase: ComicsUseCase
): BaseViewModel() {

    private val _state = MutableLiveData(ComicListState())
    val state: LiveData<ComicListState> get() = _state


    override fun handleAction(action: Action) {
        when (action) {
            is ComicListScreenAction.OnTryAgainClick -> tryAgain()
        }
    }

    init {
        getData()
    }

    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val comicList = comicsUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        comicUIState = ScreenUIState.Success,
                        comicList = comicList
                    )
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        comicUIState = ScreenUIState.Error(error = exception.message.orEmpty())
                    )
                }
            }
        }
    }

    private fun tryAgain() {
        _state.value = _state.value?.copy(
            comicUIState = ScreenUIState.Loading
        )
        getData()
    }
}
