package com.example.proyectofinal.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar(
    text: String
) {
    TopAppBar(
        backgroundColor = Color.Black,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    color = Color.White
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarScreenPreview() {
    TopBar(text = "AppTitle")
}