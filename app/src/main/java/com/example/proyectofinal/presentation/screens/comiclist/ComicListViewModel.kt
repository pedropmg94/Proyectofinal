package com.example.proyectofinal.presentation.screens.comiclist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.usecase.GetComicListUseCase
import com.example.proyectofinal.presentation.common.ScreenUIState2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicListViewModel(
    private val getComicListUseCase: GetComicListUseCase
): ViewModel() {

    private val _state = MutableLiveData(ComicListState())
    val state: LiveData<ComicListState> get() = _state

    init {
        getData()
    }

    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val comicList = getComicListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = ComicListState(
                        comicUIState = ScreenUIState2.Success,
                        comicList = comicList
                    )
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _state.value = ComicListState(
                        comicUIState = ScreenUIState2.Error(error = exception.message.orEmpty()),
                        comicList = emptyList()
                    )
                }
            }
        }
    }

    fun retryComic() {
        _state.value = ComicListState(
            comicUIState = ScreenUIState2.Loading,
            comicList = emptyList()
        )
        getData()
    }
}
