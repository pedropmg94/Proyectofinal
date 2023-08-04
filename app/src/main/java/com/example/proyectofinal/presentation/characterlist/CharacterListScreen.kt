package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
) {
    val state = characterListViewModel.ui.observeAsState()

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val characterList = state.value
        items(characterList?.items?.size ?: 0) { i ->
            val item = characterList?.items?.get(i)
            item?.let { character ->
                CharacterItem(character) {
                    onItemClick.invoke(character.id)
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