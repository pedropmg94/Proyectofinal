package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.ui.theme.*

@Composable
fun CharacterItem(
    character: CharacterModel,
    onClick: () -> Unit,
) {

    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            CharacterImage(character)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CharacterInfo(character)
                }

                // Star
                /*AndroidView(
                    modifier = Modifier.clickable {
                        val newState = !starred
                        starred = newState
                    },
                    factory = { context ->
                        StarComponent(context).apply {
                            this.checked = starred
                        }
                    },
                    update = {
                        it.checked = starred
                    }
                )*/

            }
        }
    }
}

@Composable
fun CharacterImage(character: CharacterModel) {
    AsyncImage(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = ImageRequest.Builder(LocalContext.current)
            .data(character.photoURL)
            .build(), contentDescription = ""
    )
}

@Composable
fun CharacterInfo(character: CharacterModel) {
    Text(
        text = character.name,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
    Text(
        text = character.description,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
@Preview
fun MovieListFragmentScreenPreview() {

    val mockCharacter = CharacterModel(
        id = 1,
        name = "Prueba",
        description = "Descripción de prueba",
        photoURL =  "httpsdeprueba"
    )

    CharacterItem(mockCharacter) {

    }
}