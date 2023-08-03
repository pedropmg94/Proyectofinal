package com.example.proyectofinal.presentation.movielist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieListFragment(
    onLoginSuccess: () -> Unit,
    onForgotClicked: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color(0xFFE1F5FF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.Person, // Utiliza el ícono predeterminado de usuario de Compose
            contentDescription = "User Profile Image",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            tint = Color.Black // Cambia el color del ícono si es necesario
        )

        Text(
            text = "Moncinemaddddddd drfgtrhyehydhfdydjtyjt ujfgujufkfkyu",
            fontSize = 20.sp,
            color = Color(0xFF800080),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp),
            overflow = TextOverflow.Clip,
            maxLines = 2

        )
    }
}



@Preview
@Composable
fun MovieListFragmentScreenPreview() {
    MovieListFragment(
        onLoginSuccess = {},
        onForgotClicked = { test -> }
    )
}