package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.components.StarComponent
import com.example.proyectofinal.presentation.ui.theme.*

@Composable
fun CharacterItem(
    character: CharacterModel,
    onClick: () -> Unit,
) {
    var starred by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            //verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CharacterName(character)
                Spacer(modifier = Modifier.width(10.dp))
                StarIcon()
            }

            CharacterImage(character)

        }
    }
}

@Composable
fun CharacterImage(character: CharacterModel) {
    AsyncImage(
        model = character.photoURL,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun CharacterName(character: CharacterModel) {
    Text(
        text = character.name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun StarIcon() {

    var starred by remember {
        mutableStateOf(false)
    }

    AndroidView(
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



/*AsyncImage(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = character.photoURL,
        //onError = { it.result.throwable.message?.let { it1 -> Log.e("Pedro", it1) } },
        contentDescription = ""
    )*/