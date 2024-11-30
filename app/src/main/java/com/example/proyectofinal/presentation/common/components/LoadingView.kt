package com.example.proyectofinal.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.presentation.theme.globalElevation
import com.example.proyectofinal.presentation.theme.globalPadding
import com.example.proyectofinal.presentation.theme.globalRoundedCornerShape

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CardSkeleton() {
    Column {
        repeat(2) {
            CardItemSkeleton()
        }
    }
}

@Composable
private fun CardItemSkeleton() {
    Card(
        modifier = Modifier
            .padding(globalPadding)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(globalElevation),
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Simula el nombre del personaje
                Box(
                    modifier = Modifier
                        .width(150.dp) // Simula el ancho del texto del nombre
                        .height(20.dp) // Simula la altura del texto
                        .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                )

                Spacer(modifier = Modifier.width(10.dp))

                // Simula el ícono de estrella (favoritos)
                Box(
                    modifier = Modifier
                        .size(24.dp) // Tamaño del ícono
                        .background(Color.Gray, shape = CircleShape) // Icono circular gris claro
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Simula la imagen del personaje
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) // Simula la altura de la imagen
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)) // Imagen de fondo gris claro
            )
        }
    }
}

