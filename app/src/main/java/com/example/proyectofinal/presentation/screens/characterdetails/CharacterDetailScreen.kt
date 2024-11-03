package com.example.proyectofinal.presentation.screens.characterdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proyectofinal.R
import com.example.proyectofinal.presentation.common.components.ScaffoldTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(
    id: Int,
    characterDetailViewModel: CharacterDetailViewModel = koinViewModel()
) {
    val characterState = characterDetailViewModel.ui.observeAsState()
    characterDetailViewModel.getCharacter(id)
    val result = characterState.value

    ScaffoldTopBar(
        onTabClick = { },
        topBarText = result?.name.orEmpty()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            CharacterImage(result?.photoURL)
            CharacterDescription(result?.description)
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
        contentDescription = ""
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