package com.example.proyectofinal.presentation.serielist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.comiclist.ContentComicList
import com.example.proyectofinal.presentation.comiclist.UIComicState
import com.example.proyectofinal.presentation.components.CardItem
import com.example.proyectofinal.presentation.components.ContentErrorState
import com.example.proyectofinal.presentation.components.ContentLoadingState
import com.example.proyectofinal.presentation.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun SerieListScreen(
    serieListViewModel: SerieListViewModel = koinViewModel(),
    //onItemClick: (Int) -> Unit
    onTabItem: (Int) -> Unit
) {
    val state = serieListViewModel.ui.observeAsState()

    ScaffoldTopBar(onTabClick = {
        onTabItem(it)
    },
        tabSelected = 2
    ) {
        Column(modifier = Modifier.padding(it)) {

            when(state.value) {
                is UISerieState.Loading -> {
                    val uistate = state.value as UISerieState.Loading
                    ContentLoadingState()
                }

                is UISerieState.Loaded -> {
                    val uistate = state.value as UISerieState.Loaded
                    ContentSerieList(serieList = uistate.items)
                }

                is UISerieState.Error -> {
                    val uistate = state.value as UISerieState.Error
                    ContentErrorState(
                        uistate.error ?: "Unknown error",
                        onClickRetry = { serieListViewModel.retrySerie() }
                    )
                }

                else -> {}
            }
        }

    }
}



@Composable
fun ContentSerieList(
    //onItemClick: (Int) -> Unit
    //onTabItem: (Int) -> Unit,
    serieList: List<SerieModel>
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(serieList.size ?: 0) { i ->
            val item = serieList.get(i)
            item?.let { serie ->
                //println(character)
                CardItem(
                    item = serie,
                    onClick = { /*TODO*/ },
                    nameProvider = {serie.title},
                    photoURLProvider = {serie.photoURL}
                )
            }
        }
    }
}


@Preview
@Composable
fun MovieListScreenPreview() {
    SerieListScreen(
        //onItemClick = {},
        onTabItem = {}
    )
}