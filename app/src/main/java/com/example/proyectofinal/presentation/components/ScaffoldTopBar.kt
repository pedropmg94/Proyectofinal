package com.example.proyectofinal.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.proyectofinal.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBar(onTabClick: (Int) -> Unit, screen: @Composable( )(PaddingValues) -> Unit) {
    val tabs = listOf("Personajes", "Comics", "Series")

    Scaffold(topBar = {
        HeaderTabLayout(
            tabs = tabs,
            onTabSelected = { tabIndex ->
                Log.e("Indice", tabIndex.toString())
                onTabClick(tabIndex)
            }
        )
    }) {
        screen(it)
    }
}