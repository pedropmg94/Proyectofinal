package com.example.proyectofinal.presentation.movielist

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieList(
    onLoginSuccess: () -> Unit,
    onForgotClicked: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1F5FF))
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Icon(
            imageVector = Icons.Default.Person, // Utiliza el ícono predeterminado de usuario de Compose
            contentDescription = "User Profile Image",
            modifier = Modifier.size(150.dp),
            tint = Color.Black // Cambia el color del ícono si es necesario
        )*/

        Text(
            text = "Moncinema",
            fontSize = 30.sp,
            letterSpacing = 5.sp,
            color = Color(0xFF800080)

        )

        Spacer(modifier = Modifier.height(100.dp))

        //EmailBox()

        Spacer(modifier = Modifier.height(10.dp))

        //PasswordBox()

        Spacer(modifier = Modifier.height(50.dp))

        //LoginButton(onLoginSuccess)

        Spacer(modifier = Modifier.height(20.dp))

        /*Button(onClick = { onForgotClicked.invoke(0) }) {
            Text(
                text = "Forgot"
            )
        }*/

    }
}



@Preview
@Composable
fun MovieListScreenPreview() {
    MovieList(
        onLoginSuccess = {},
        onForgotClicked = { test -> }
    )
}