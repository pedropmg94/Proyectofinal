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

    private val _ui = MutableLiveData<UIComicState>(UIComicState.Loading())
    val ui: LiveData<UIComicState> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val comicList = getComicListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = UIComicState.Loaded(items = comicList)
                }
            } catch(exception: Exception){
                withContext(Dispatchers.Main) {
                    _ui.value = UIComicState.Error(error = exception.message)
                }
            }
        }
    }

    fun retryComic() {
        _ui.value = UIComicState.Loading()
        getData()
    }


}


sealed class UIComicState() {
    class Loading(): UIComicState()
    class Loaded(val items: List<ComicModel>): UIComicState()
    class Error(val error: String? = null): UIComicState()

}