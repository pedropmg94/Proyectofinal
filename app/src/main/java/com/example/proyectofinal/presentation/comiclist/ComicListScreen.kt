package com.example.proyectofinal.presentation.comiclist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.presentation.characterlist.CharacterListScreen
import com.example.proyectofinal.presentation.components.CardItem
import com.example.proyectofinal.presentation.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun ComicListScreen(
    comicListViewModel: ComicListViewModel = koinViewModel(),
    //onItemClick: (Int) -> Unit
    onTabItem: (Int) -> Unit
) {
    val state = comicListViewModel.ui.observeAsState()
    ScaffoldTopBar(onTabClick = {
        onTabItem(it)
    }) {
        LazyColumn(
            Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val comicList = state.value
            items(comicList?.items?.size ?: 0) { i ->
                val item = comicList?.items?.get(i)
                item?.let { comic ->
                    //println(comic)
                    CardItem(
                        item = comic,
                        onClick = { /*TODO*/ },
                        nameProvider = {comic.title},
                        photoURLProvider = {comic.photoURL}
                    )
                }
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