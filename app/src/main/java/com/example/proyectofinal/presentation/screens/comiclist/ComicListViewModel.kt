package com.example.proyectofinal.presentation.screens.comiclist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.usecase.GetComicListUseCase
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.BaseViewModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicListViewModel(
    private val getComicListUseCase: GetComicListUseCase
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
                val comicList = getComicListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        comicUIState = ScreenUIState2.Success,
                        comicList = comicList
                    )
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        comicUIState = ScreenUIState2.Error(error = exception.message.orEmpty())
                    )
                }
            }
        }
    }

    private fun tryAgain() {
        _state.value = _state.value?.copy(
            comicUIState = ScreenUIState2.Loading
        )
        getData()
    }
}
