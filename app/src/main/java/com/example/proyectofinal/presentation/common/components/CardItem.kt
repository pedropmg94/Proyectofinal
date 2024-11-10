package com.example.proyectofinal.presentation.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.proyectofinal.R
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.presentation.theme.globalElevation
import com.example.proyectofinal.presentation.theme.globalPadding
import com.example.proyectofinal.presentation.theme.globalRoundedCornerShape

@Composable
fun CardItem(
    onClick: () -> Unit,
    nameProvider: String,
    photoURLProvider: String,
    favModel: FavModel? = null,
    favClick: (FavModel) -> Unit = {}
) {
    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = CardDefaults.cardElevation(globalElevation),
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
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CharacterName(nameProvider)

                Spacer(modifier = Modifier.width(10.dp))

                if (favModel != null) {
                    StarIcon(favModel, favClick)
                }
            }
            ItemImage(nameProvider, photoURLProvider)
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
fun ItemImage(itemName: String, itemPhotoURL: String) {
    AsyncImage(
        placeholder = painterResource(id = R.drawable.marvellogo),
        error = painterResource(id = R.drawable.marvellogo),
        model = itemPhotoURL,
        contentDescription = itemName,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun StarIcon(
    favModel: FavModel,
    favClick: (FavModel) -> Unit
) {
    IconButton(
        onClick = {
            favClick(favModel.copy(favorite = !favModel.favorite))
        }
    ) {
        Icon(
            painter = if (favModel.favorite) {
                painterResource(R.drawable.star_filled)
            } else {
                painterResource(R.drawable.star)
            },
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
    }
}
