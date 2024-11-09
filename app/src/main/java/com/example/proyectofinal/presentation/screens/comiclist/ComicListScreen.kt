package com.example.proyectofinal.presentation.screens.comiclist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.ScreenUIState2
import com.example.proyectofinal.presentation.common.components.CardItem
import com.example.proyectofinal.presentation.common.components.ErrorView
import com.example.proyectofinal.presentation.common.components.LoadingView
import com.example.proyectofinal.presentation.common.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComicListScreen(
    viewModel: ComicListViewModel = koinViewModel(),
    //onItemClick: (Int) -> Unit
    onTabItem: (Int) -> Unit
) {
    val state by viewModel.state.observeAsState(ComicListState())
    
    ScaffoldTopBar(
        onTabClick = {
            onTabItem(it)
        },
        topBarText = AppTitle
    ) {
        Column(modifier = Modifier.padding(it)) {
            when (state.comicUIState) {
                is ScreenUIState2.Loading -> {
                    LoadingView()
                }

                is ScreenUIState2.Success -> {
                    ContentComicList(comicList = state.comicList)
                }

                is ScreenUIState2.Error -> {
                    ErrorView(
                        error = (state.comicUIState as ScreenUIState2.Error).error,
                        onClickRetry = { viewModel.retryComic() }
                    )
                }
            }
        }

    }
}

@Composable
fun ContentComicList(
    //onItemClick: (Int) -> Unit,
    //onTabItem: (Int) -> Unit
    comicList: List<ComicModel>
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(comicList) { comic ->
            CardItem(
                item = comic,
                onClick = { /*TODO*/ },
                nameProvider = { comic.title },
                photoURLProvider = { comic.photoURL }
            )
        }
    }
}


@Preview
@Composable
fun MovieListScreenPreview() {
    ComicListScreen(
        //onItemClick = {},
        onTabItem = {}
    )
}

private const val AppTitle = "MARVELIX"
