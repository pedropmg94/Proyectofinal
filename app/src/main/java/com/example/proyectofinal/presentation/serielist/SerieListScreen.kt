package com.example.proyectofinal.presentation.serielist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.proyectofinal.presentation.components.CardItem
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
        LazyColumn(
            Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val serieList = state.value
            items(serieList?.items?.size ?: 0) { i ->
                val item = serieList?.items?.get(i)
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
}


@Preview
@Composable
fun MovieListScreenPreview() {
    SerieListScreen(
        //onItemClick = {},
        onTabItem = {}
    )
}