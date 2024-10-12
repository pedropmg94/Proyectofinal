package com.example.proyectofinal.presentation.comiclist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.components.CardItem
import com.example.proyectofinal.presentation.components.ContentErrorState
import com.example.proyectofinal.presentation.components.ContentLoadingState
import com.example.proyectofinal.presentation.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComicListScreen(
    comicListViewModel: ComicListViewModel = koinViewModel(),
    //onItemClick: (Int) -> Unit
    onTabItem: (Int) -> Unit
) {
    val state = comicListViewModel.ui.observeAsState()
    ScaffoldTopBar(
        onTabClick = {
            onTabItem(it)
        },
        topBarText = AppTitle
    ) {
        Column(modifier = Modifier.padding(it)) {

            when (state.value) {
                is UIComicState.Loading -> {
                    val uistate = state.value as UIComicState.Loading
                    ContentLoadingState()
                }

                is UIComicState.Loaded -> {
                    val uistate = state.value as UIComicState.Loaded
                    ContentComicList(comicList = uistate.items)
                }

                is UIComicState.Error -> {
                    val uistate = state.value as UIComicState.Error
                    ContentErrorState(
                        uistate.error ?: "Unknown error",
                        onClickRetry = { comicListViewModel.retryComic() }
                    )
                }

                else -> {}
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
        items(comicList.size) { i ->
            val item = comicList.get(i)
            item.let { comic ->
                //println(comic)
                CardItem(
                    item = comic,
                    onClick = { /*TODO*/ },
                    nameProvider = { comic.title },
                    photoURLProvider = { comic.photoURL }
                )
            }
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
