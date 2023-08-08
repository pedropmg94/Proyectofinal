package com.example.proyectofinal.presentation.serielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.domain.usecase.GetSerieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SerieListViewModel(
    private val getSerieListUseCase: GetSerieListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<SerieListUI>()
    val ui: LiveData<SerieListUI> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            val serieList = getSerieListUseCase.invoke()
            withContext(Dispatchers.Main) {
                _ui.value = SerieListUI(items = serieList)
            }
        }
    }

}

data class SerieListUI(val items: List<SerieModel>)
