package com.example.proyectofinal.presentation.characterlist

import android.util.Log
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                },
            //verticalAlignment = Alignment.CenterVertically
        ) {
            CharacterName(character)
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
        modifier = Modifier.fillMaxSize() // Tanto el ancho como el alto ocuparán el espacio disponible
    )/*
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        AsyncImage(
            model = character.photoURL,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize() // Tanto el ancho como el alto ocuparán el espacio disponible
        )
    }*/
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