package com.example.proyectofinal.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.proyectofinal.R
import com.example.proyectofinal.presentation.theme.globalElevation
import com.example.proyectofinal.presentation.theme.globalPadding
import com.example.proyectofinal.presentation.theme.globalRoundedCornerShape

@Composable
fun <T : Any> CardItem(
    item: T,
    onClick: () -> Unit,
    nameProvider: (T) -> String,
    photoURLProvider: (T) -> String
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
                }
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CharacterName(nameProvider(item))

                Spacer(modifier = Modifier.width(10.dp))

                StarIcon()
            }
            ItemImage(photoURLProvider(item))
        }
    }
}


@Composable
fun CharacterName(itemName: String) {
    Text(
        text = itemName,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun ItemImage(itemPhotoURL: String) {
    AsyncImage(
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = itemPhotoURL,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
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
fun <T : Any> ItemCardPreview(item: T) {
    CardItem(
        item = item,
        onClick = {},
        nameProvider = { "Nombre" },
        photoURLProvider = { "URL de la foto" }
    )
}

