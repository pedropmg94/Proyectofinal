package com.example.proyectofinal.presentation.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ScaffoldView(
    onTabClick: (Int) -> Unit,
    tabCurrentIndex: Int,
    topBarText: String,
    screen: @Composable() (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(text = topBarText)
        },
        bottomBar = {
            BottomBar(
                onTabSelected = { tabIndex ->
                    onTabClick(tabIndex)
                },
                currentIndex = tabCurrentIndex
            )
        },
        containerColor = Color.Black
    ) {
        Box(modifier = Modifier.padding(it)) {
            screen(it)
        }
    }
}