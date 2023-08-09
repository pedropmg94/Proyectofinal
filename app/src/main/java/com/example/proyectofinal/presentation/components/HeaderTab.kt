package com.example.proyectofinal.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
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

@Composable
fun HeaderTabLayout(
    tabs: List<String>,
    tabSelected: Int,
    onTabSelected: (Int) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[tabSelected]),
                color = Color.LightGray
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Box(
                    modifier = Modifier.height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = tab)
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}


@Preview
@Composable
fun HeaderTabLayoutPreview() {
    val tabs = listOf("Personajes", "Comics", "Series")

    HeaderTabLayout(
        tabs = tabs,
        tabSelected = 0,
        //modifier = Modifier.fillMaxWidth(),
        onTabSelected = {}
    )
}
