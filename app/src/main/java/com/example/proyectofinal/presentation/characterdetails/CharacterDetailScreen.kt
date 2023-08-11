package com.example.proyectofinal.presentation.characterdetails

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.components.ShowError
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(
    id: Int,
    characterDetailViewModel: CharacterDetailViewModel = koinViewModel()
) {

    val characterState = characterDetailViewModel.ui.observeAsState()

    characterDetailViewModel.getCharacter(id)

    val result = characterState.value

    result?.let { character ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE1F5FF))
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CharacterName(character)
                Spacer(modifier = Modifier.width(10.dp))
                //StarIcon(character.favModel, favClick = {characterDetailViewModel.setFav(it)})
            }

            Spacer(modifier = Modifier.height(50.dp))

            CharacterImage(character)

            Spacer(modifier = Modifier.height(50.dp))

            CharacterDescription(character)

        }
    } ?: run {
        ShowError("Unknown error")
    }


}


@Composable
fun CharacterImage(character: CharacterModel) {
    Log.e("Pedraco", character.photoURL)
    AsyncImage(
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape),
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = character.photoURL,
        contentDescription = ""
    )
}

@Composable
fun CharacterName(character: CharacterModel) {
    Text(
        text = character.name,
        maxLines = 1,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CharacterDescription(character: CharacterModel) {
    Log.e("Pedraco", character.description)
    Text(
        text = character.description,
        maxLines = 10,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
fun LoginScreenPreview() {
    /*val mockCharacter = Characte(
        id = 1,
        name = "Prueba",
        description = "Descripción de prueba",
        photoURL =  "httpsdeprueba"
    )
    CharacterDetailScreen(1, mockCharacter)*/
}