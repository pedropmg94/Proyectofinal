package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.presentation.components.CardItem
import com.example.proyectofinal.presentation.components.ContentErrorState
import com.example.proyectofinal.presentation.components.ContentLoadingState
import com.example.proyectofinal.presentation.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit,
    onTabItem: (Int) -> Unit
) {
    val state = characterListViewModel.ui.observeAsState()
    ScaffoldTopBar(onTabClick = {
        onTabItem(it)
    },
        tabSelected = 0
    ) {
        Column(modifier = Modifier.padding(it)) {

            when(state.value) {
                is UILoginState.Loading -> {
                    val uistate = state.value as UILoginState.Loading
                    ContentLoadingState()
                }

                is UILoginState.Loaded -> {
                    val uistate = state.value as UILoginState.Loaded
                    ContentCharacterList(
                        onItemClick = onItemClick,
                        //onTabItem = onTabItem,
                        characterList = uistate.items,
                        favClick = { characterListViewModel.setFav(it) }
                    )
                }

                is UILoginState.Error -> {
                    val uistate = state.value as UILoginState.Error
                    ContentErrorState(
                        uistate.error ?: "Unknown error",
                        onClickRetry = { characterListViewModel.retryCharacter() }
                    )
                }
                else -> {}
            }
        }
    }
}



@Composable
fun ContentCharacterList(
    onItemClick: (Int) -> Unit,
    //onTabItem: (Int) -> Unit,
    characterList: List<CharacterModel>,
    favClick: (FavModel) -> Unit
) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(characterList.size ?: 0) { i ->
                val item = characterList.get(i)
                item?.let { character ->
                    CardItem(
                        item = character,
                        onClick = { onItemClick.invoke(character.id) },
                        nameProvider = {character.name},
                        photoURLProvider = {character.photoURL},
                        favClick = favClick
                    )
                }
            }
        }
}


@Preview
@Composable
fun MovieListScreenPreview() {
    CharacterListScreen(
        onItemClick = {},
        onTabItem = {}
    )
}