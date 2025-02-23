package com.example.proyectofinal.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ComicTable)
data class ComicLocalEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val photoUrl: String,
)

const val ComicTable = "comics"