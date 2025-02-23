package com.example.proyectofinal.presentation.screens.serielist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.components.CardItem
import com.example.proyectofinal.presentation.common.components.ErrorView
import com.example.proyectofinal.presentation.common.components.LoadingView
import com.example.proyectofinal.presentation.common.components.ScaffoldView

@Composable
fun SerieListScreen(
    state: SerieListState,
    onTabItem: (Int) -> Unit,
    tabCurrentIndex: Int,
    onActions: (Action) -> Unit
) {
    ScaffoldView(
        onTabClick = {
            onTabItem(it)
        },
        tabCurrentIndex = tabCurrentIndex,
        topBarText = stringResource(id = R.string.app_title)
    ) {
        when (state.serieUIState) {
            is ScreenUIState.Loading -> LoadingView()
            is ScreenUIState.Success -> ContentSerieList(serieList = state.serieList)
            is ScreenUIState.Error -> {
                ErrorView(
                    error = state.serieUIState.error,
                    onClickRetry = {
                        onActions(
                            SerieListScreenAction.OnTryAgainClick
                        )
                    }
                )
            }
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
        state = SerieListState(),
        onTabItem = {},
        tabCurrentIndex = 2,
        onActions = {}
    )
}
