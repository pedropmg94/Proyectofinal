package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.proyectofinal.presentation.login.LoginScreen
import com.example.proyectofinal.ui.theme.ProyectoFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        onLoginSuccess = {},
                    )
                }
            }
        }
    }
}

/*
private fun borrarPreferencias() {
    getPreferences(Context.MODE_PRIVATE).edit().clear().apply()
}

private fun guardarLoginEnPreferencias(user: String, pass: String) {
    getPreferences(Context.MODE_PRIVATE).edit()
        .putString("USER_TAG", user)
        .putString("PASS_TAG", pass)
        .apply()
}

private fun cargarLoginDePreferencias() {
        getPreferences(Context.MODE_PRIVATE).apply {
            etUser.setText(getString(userTag, ""))
            etPass.setText(getString(passTag, ""))
            if (etPass.text.isNotEmpty() && etUser.text.isNotEmpty())
                cbSave.isChecked = true
    }
}

private fun lanzarLogin(user: String, pass: String) {
    //Añado lo de dentro del parentesis pq sino la corrutina se ejecuta en el mismo hilo y seguimos teniendo el mismo problema
    //Main = hilos de la interfaz gráfica
    //Conexiones a internet a base de datos o lo que sea IO
    lifecycleScope.launch(Dispatchers.IO) {
        when(val state = viewModel.loguear(user, pass)) {
            is MainActivityViewModel.LoginState.OnSuccess -> abrirHeroListActivity()
            is MainActivityViewModel.LoginState.OnError -> {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, state.message, Toast.LENGTH_LONG)
                }
            }
        }
    }
}
*/