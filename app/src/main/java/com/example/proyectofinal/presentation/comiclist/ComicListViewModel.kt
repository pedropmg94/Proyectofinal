package com.example.proyectofinal.presentation.comiclist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.domain.usecase.GetComicListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicListViewModel(
    private val getComicListUseCase: GetComicListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<ComicListUI>()
    val ui: LiveData<ComicListUI> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            val comicList = getComicListUseCase.invoke()
            withContext(Dispatchers.Main) {
                _ui.value = ComicListUI(items = comicList)
            }
        }
    }

}

data class ComicListUI(val items: List<ComicModel>)
