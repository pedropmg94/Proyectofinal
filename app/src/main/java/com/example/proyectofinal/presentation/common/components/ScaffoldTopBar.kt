package com.example.proyectofinal.presentation.common.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBar(
    onTabClick: (Int) -> Unit,
    topBarText: String,
    screen: @Composable() (PaddingValues) -> Unit
) {
    val tabs = listOf("Characters", "Comics", "Series")

    Scaffold(
        topBar = {
            TopBar(text = topBarText)
        },
        bottomBar = {
            BottomBar(
                tabs = tabs,
                onTabSelected = { tabIndex ->
                    onTabClick(tabIndex)
                }
            )
        },
        containerColor = Color.Black
    ) {
        screen(it)
    }
}