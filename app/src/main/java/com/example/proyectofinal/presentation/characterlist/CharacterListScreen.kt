package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.presentation.components.CardItem
import com.example.proyectofinal.presentation.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
) {
    val state = characterListViewModel.ui.observeAsState()

    ScaffoldTopBar(onItemClick = {})
    {
        LazyColumn(
            Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val characterList = state.value
            items(characterList?.items?.size ?: 0) { i ->
                val item = characterList?.items?.get(i)
                item?.let { character ->
                    //println(character)
                    CardItem(
                        item = character,
                        onClick = { onItemClick.invoke(character.id) },
                        nameProvider = {character.name},
                        photoURLProvider = {character.photoURL}
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun MovieListScreenPreview() {
    CharacterListScreen {

    }
}