package com.example.proyectofinal.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBar(onItemClick: (Int) -> Unit, screen: @Composable( )(PaddingValues) -> Unit) {
    Scaffold(topBar = {
        val tabs = listOf("Personajes", "Comics", "Series")

        HeaderTabLayout(
            tabs = tabs,
            //modifier = Modifier.fillMaxWidth(),
            onTabSelected = {onItemClick}
        )
    }) {
        screen(it)
    }
}