package com.example.proyectofinal.presentation.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.ui.theme.PurpleText

@Composable
fun TopBar(
    onIconClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color.White,
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Moncinema",
                    color = PurpleText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                IconButton(onClick = onIconClick) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "User Icon",
                        modifier = Modifier.size(40.dp),
                        tint = Color.Black
                    )
                }
            }
        }
    )
}


@Preview
@Composable
fun TopBarScreenPreview() {
    TopBar(
        onIconClick = {}
    )
}