package com.example.proyectofinal.presentation.screens.serielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.domain.usecase.SeriesUseCase
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.BaseViewModel
import com.example.proyectofinal.presentation.common.ScreenUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SerieListViewModel(
    private val seriesUseCase: SeriesUseCase
    ): BaseViewModel() {

    private val _state = MutableLiveData(SerieListState())
    val state: LiveData<SerieListState> get() = _state

    override fun handleAction(action: Action) {
        when (action) {
            is SerieListScreenAction.OnTryAgainClick -> tryAgain()
        }
    }

    init {
        getData()
    }

    private fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val serieList = seriesUseCase.invoke()
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        serieUIState = ScreenUIState.Success,
                        serieList = serieList
                    )
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value?.copy(
                        serieUIState = ScreenUIState.Error(error = exception.message.orEmpty())
                    )
                }
            }
        }
    }

    private fun tryAgain() {
        _state.value = _state.value?.copy(
            serieUIState = ScreenUIState.Loading
        )
        getData()
    }
}
