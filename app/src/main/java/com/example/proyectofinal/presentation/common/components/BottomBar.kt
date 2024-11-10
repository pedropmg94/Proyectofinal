package com.example.proyectofinal.presentation.common.components

import androidx.compose.material.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomBar(
    onTabSelected: (Int) -> Unit,
    currentIndex: Int
) {
    val tabs = listOf("Characters", "Comics", "Series")

    TabRow(
        selectedTabIndex = currentIndex,
        backgroundColor = Color.Black
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = currentIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        color = if (currentIndex == index) Color.White else Color.Gray,
                        fontWeight = if (currentIndex == index) FontWeight.Bold else FontWeight.Normal,
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun HeaderTabLayoutPreview() {
    BottomBar(
        onTabSelected = {},
        currentIndex = 0
    )
}
