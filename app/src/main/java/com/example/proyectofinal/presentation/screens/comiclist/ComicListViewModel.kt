package com.example.proyectofinal.presentation.screens.comiclist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.domain.usecase.GetComicListUseCase
import com.example.proyectofinal.presentation.common.ScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicListViewModel(
    private val getComicListUseCase: GetComicListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<ScreenUIState<List<ComicModel>>>(ScreenUIState.Loading)
    val ui: LiveData<ScreenUIState<List<ComicModel>>> get() = _ui

    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val comicList = getComicListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = ScreenUIState.Success(data = comicList)
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _ui.value = ScreenUIState.Error(error = exception.message)
                }
            }
        }
    }

    fun retryComic() {
        _ui.value = ScreenUIState.Loading
        getData()
    }
}
