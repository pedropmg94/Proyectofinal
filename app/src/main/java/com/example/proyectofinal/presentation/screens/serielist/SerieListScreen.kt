package com.example.proyectofinal.presentation.screens.serielist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.components.CardItem
import com.example.proyectofinal.presentation.common.components.ErrorView
import com.example.proyectofinal.presentation.common.components.LoadingView
import com.example.proyectofinal.presentation.common.components.ScaffoldView
import org.koin.androidx.compose.koinViewModel

@Composable
fun SerieListScreen(
    serieListViewModel: SerieListViewModel = koinViewModel(),
    onTabItem: (Int) -> Unit,
    tabCurrentIndex: Int,
) {
    val state = serieListViewModel.ui.observeAsState()

    ScaffoldView(
        onTabClick = {
            onTabItem(it)
        },
        tabCurrentIndex = tabCurrentIndex,
        topBarText = stringResource(id = R.string.app_title)
    ) {
        when (state.value) {
            is UISerieState.Loading -> {
                LoadingView()
            }

            is UISerieState.Loaded -> {
                val uiState = state.value as UISerieState.Loaded
                ContentSerieList(serieList = uiState.items)
            }

            is UISerieState.Error -> {
                val uiState = state.value as UISerieState.Error
                ErrorView(
                    uiState.error ?: "Unknown error",
                    onClickRetry = { serieListViewModel.retrySerie() }
                )
            }

            else -> {}
        }
    }
}


@Composable
fun ContentSerieList(
    serieList: List<SerieModel>
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(serieList) { serie ->
            CardItem(
                onClick = { /*TODO*/ },
                nameProvider = serie.title,
                photoURLProvider = serie.photoURL
            )
        }
    }
}

@Preview
@Composable
fun MovieListScreenPreview() {
    SerieListScreen(
        onTabItem = {},
        tabCurrentIndex = 2
    )
}
