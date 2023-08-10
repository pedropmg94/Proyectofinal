package com.example.proyectofinal.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBar(onTabClick: (Int) -> Unit, tabSelected: Int, screen: @Composable( )(PaddingValues) -> Unit) {
    val tabs = listOf("Characters", "Comics", "Series")

    Scaffold(topBar = {
        HeaderTabLayout(
            tabs = tabs,
            tabSelected = tabSelected,
            onTabSelected = { tabIndex ->
                onTabClick(tabIndex)
            }
        )
    }) {
        screen(it)
    }
}