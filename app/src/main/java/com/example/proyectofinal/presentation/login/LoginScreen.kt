package com.example.proyectofinal.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    // Prueba de paso de parámetros
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

        EmailBox()

        Spacer(modifier = Modifier.height(10.dp))

        PasswordBox()

        Spacer(modifier = Modifier.height(50.dp))

        LoginButton(onLoginSuccess)

        Spacer(modifier = Modifier.height(20.dp))

        RememberPasswordCheckbox()

    }
}


@Composable
fun EmailBox() {
    var email by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = email,
        label = {
            Text("Email")
        },
        onValueChange = { newValue ->
            email = newValue
        },
        singleLine = true,
        leadingIcon = {
            Image(
                imageVector = Icons.Default.Email,
                contentDescription = ""
            )
        }
    )
}

@Composable
fun PasswordBox() {

    var password by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = password,
        label = {
            Text("Password")
        },
        onValueChange = {
            password = it
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock,
                contentDescription = ""
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Face,
                    contentDescription = ""
                )
            }
        }
    )
}

@Composable
fun LoginButton(onLoginSuccess: () -> Unit) {

    Button(
        onClick = onLoginSuccess,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(16.dp), // Bordes redondeados
        border = BorderStroke(2.dp, Color(0xFF9400D3)), // Borde lila
        colors = ButtonDefaults.buttonColors(Color(0xFFE1F5FF))
    ) {
        Text(
            text = "LOGIN"
        )
    }
}

@Composable
fun RememberPasswordCheckbox() {
    var rememberMe by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = rememberMe,
            onCheckedChange = { rememberMe = it }
        )
        Text(text = "Remember Password")
    }
}



@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {},
        onForgotClicked = { test -> }
    )
}