package com.example.proyectofinal.presentation.serielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.domain.usecase.GetSerieListUseCase
import com.example.proyectofinal.presentation.characterlist.UILoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SerieListViewModel(
    private val getSerieListUseCase: GetSerieListUseCase
    ): ViewModel() {

    init {
        getData()
    }

    private val _ui = MutableLiveData<UISerieState>(UISerieState.Loading())
    val ui: LiveData<UISerieState> get() = _ui


    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val serieList = getSerieListUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _ui.value = UISerieState.Loaded(items = serieList)
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    _ui.value = UISerieState.Error(error = exception.message)
                }

            }
        }

    }

    fun retrySerie() {
        _ui.value = UISerieState.Loading()
        getData()
    }
}

sealed class UISerieState() {
    class Loading(): UISerieState()
    class Loaded(val items: List<SerieModel>): UISerieState()
    class Error(val error: String? = null): UISerieState()

}