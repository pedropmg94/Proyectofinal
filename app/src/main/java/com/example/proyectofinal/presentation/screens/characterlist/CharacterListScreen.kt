package com.example.proyectofinal.presentation.screens.characterlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.ScreenUIState
import com.example.proyectofinal.presentation.common.components.CardItem
import com.example.proyectofinal.presentation.common.components.ErrorView
import com.example.proyectofinal.presentation.common.components.LoadingView
import com.example.proyectofinal.presentation.common.components.ScaffoldView

@Composable
fun CharacterListScreen(
    state: CharacterListState,
    onItemClick: (Int) -> Unit,
    onTabItem: (Int) -> Unit,
    tabCurrentIndex: Int,
    onActions: (Action) -> Unit
) {
    ScaffoldView(
        onTabClick = {
            onTabItem(it)
        },
        tabCurrentIndex = tabCurrentIndex,
        topBarText = stringResource(id = R.string.app_title),
    ) {
        when (state.characterUIState) {
            is ScreenUIState.Loading -> LoadingView()
            is ScreenUIState.Success -> {
                ContentCharacterList(
                    onItemClick = onItemClick,
                    characterList = state.characterList,
                    onActions = onActions
                )
            }
            is ScreenUIState.Error -> {
                ErrorView(
                    error = state.characterUIState.error,
                    onClickRetry = {
                        onActions(
                            CharacterListScreenAction.OnTryAgainClick
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ContentCharacterList(
    onItemClick: (Int) -> Unit,
    characterList: List<CharacterModel>,
    onActions: (Action) -> Unit
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(characterList) { character ->
            CardItem(
                onClick = { onItemClick.invoke(character.id) },
                nameProvider = character.name,
                photoURLProvider = character.photoURL,
                favModel = character.favModel,
                favClick = { favModel ->
                    onActions(
                        CharacterListScreenAction.OnFavCharacterClick(favModel)
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun MovieListScreenPreview() {
    CharacterListScreen(
        state = CharacterListState(),
        onItemClick = {},
        onTabItem = {},
        tabCurrentIndex = 0,
        onActions = {}
    )
}
