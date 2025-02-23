package com.example.proyectofinal.presentation.screens.comiclist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.components.CardItem
import com.example.proyectofinal.presentation.common.components.ErrorView
import com.example.proyectofinal.presentation.common.components.LoadingView
import com.example.proyectofinal.presentation.common.components.ScaffoldView

@Composable
fun ComicListScreen(
    state: ComicListState,
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
        when (state.comicUIState) {
            is ScreenUIState.Loading -> LoadingView()
            is ScreenUIState.Success -> ContentComicList(comicList = state.comicList)
            is ScreenUIState.Error -> {
                ErrorView(
                    error = state.comicUIState.error,
                    onClickRetry = {
                        onActions(
                            ComicListScreenAction.OnTryAgainClick
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ContentComicList(
    comicList: List<ComicModel>
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(comicList) { comic ->
            CardItem(
                onClick = { /*TODO*/ },
                nameProvider = comic.title,
                photoURLProvider = comic.photoURL
            )
        }
    }
}

@Preview
@Composable
fun MovieListScreenPreview() {
    ComicListScreen(
        state = ComicListState(),
        onTabItem = {},
        tabCurrentIndex = 1,
        onActions = {}
    )
}
