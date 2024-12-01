package com.example.proyectofinal.presentation.screens.characterdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proyectofinal.R
import com.example.proyectofinal.presentation.common.Action
import com.example.proyectofinal.presentation.common.components.ScaffoldView
import com.example.proyectofinal.presentation.common.extension.EMPTY_STRING

@Composable
fun DetailScreen(
    state: CharacterDetailState,
    id: Int,
    onTabItem: (Int) -> Unit,
    tabCurrentIndex: Int,
    onActions: (Action) -> Unit
) {
    LaunchedEffect(key1 = id) {
        onActions(
            CharacterDetailScreenAction.OnInitialize(id, tabCurrentIndex)
        )
    }

    ScaffoldView(
        onTabClick = {
            onTabItem(it)
        },
        tabCurrentIndex = tabCurrentIndex,
        topBarText = state.name
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            CharacterImage(state.photoURL)
            CharacterDescription(state.description)
        }
    }
}

@Composable
private fun CharacterImage(photoURL: String?) {
    AsyncImage(
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape),
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = photoURL,
        contentDescription = String.EMPTY_STRING
    )
}

@Composable
private fun CharacterDescription(description: String?) {
    Text(
        text = if (description.isNullOrEmpty()) ErrorDescriptionText else description,
        modifier = Modifier.padding(horizontal = 8.dp),
        maxLines = 10,
        overflow = TextOverflow.Ellipsis,
        color = Color.White
    )
}

private const val ErrorDescriptionText = "No description found."