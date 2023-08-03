package com.example.proyectofinal.presentation.topbar

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    onIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = onIconClick) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            }
        },
        backgroundColor = Color(0xFF9400D3)
    )
}



@Preview
@Composable
fun TopBarScreenPreview() {
    /*TopBar(
        onLoginSuccess = {},
        onForgotClicked = { test -> }
    )*/
}