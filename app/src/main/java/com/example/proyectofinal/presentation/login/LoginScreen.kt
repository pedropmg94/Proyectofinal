package com.example.proyectofinal.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinal.R

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        BackgroundImage()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LogoText()

            Spacer(modifier = Modifier.height(100.dp))

            EmailBox()

            Spacer(modifier = Modifier.height(10.dp))

            PasswordBox()

            Spacer(modifier = Modifier.height(100.dp))

            LoginButton(onLoginSuccess)

            Spacer(modifier = Modifier.height(10.dp))

            RememberPasswordCheckbox()

        }

    }

}



@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.marvellogin),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}


@Composable
fun LogoText() {
    Text(
        text = "MARVEL",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            color = Color.White
        )
    )
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
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
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
        visualTransformation = PasswordVisualTransformation(),
        label = {
            Text("Password")
        },
        onValueChange = {
            password = it
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock,
                contentDescription = ""
            )
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
        border = BorderStroke(2.dp, Color.Black), // Borde lila
        colors = ButtonDefaults.buttonColors(Color.White)
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
            onCheckedChange = { rememberMe = it },
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.White
            )
        )
        Text(
            text = "Remember Password",
            style = TextStyle(color = Color.White)
        )
    }
}



@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {},
    )
}