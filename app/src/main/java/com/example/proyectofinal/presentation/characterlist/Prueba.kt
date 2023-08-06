package com.example.proyectofinal.presentation.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.presentation.ui.theme.globalElevation
import com.example.proyectofinal.presentation.ui.theme.globalPadding
import com.example.proyectofinal.presentation.ui.theme.globalRoundedCornerShape

@Composable
fun Prueba(
    character: CharacterModel
) {
    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            //verticalAlignment = Alignment.CenterVertically
        ) {

        }

    }
}


@Composable
@Preview
fun PruebaPreview() {

    val mockCharacter = CharacterModel(
        id = 1,
        name = "Pruebaaaaaaaaaaaaaaaaa",
        description = "Descripción de prueba",
        photoURL = "httpsdeprueba"
    )

    CharacterItem(mockCharacter) {

    }
}