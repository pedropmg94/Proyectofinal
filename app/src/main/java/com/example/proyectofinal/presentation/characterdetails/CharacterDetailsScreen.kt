package com.example.proyectofinal.presentation.characterdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CharacterDetailsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1F5FF))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person, // Utiliza el ícono predeterminado de usuario de Compose
            contentDescription = "User Profile Image",
            modifier = Modifier.size(150.dp),
            tint = Color.Black // Cambia el color del ícono si es necesario
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Titulo",
            fontSize = 30.sp,
            letterSpacing = 5.sp,
            color = Color(0xFF800080)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Description",
            fontSize = 30.sp,
            letterSpacing = 5.sp,
            color = Color(0xFF800080)
        )

    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    CharacterDetailsScreen()
}