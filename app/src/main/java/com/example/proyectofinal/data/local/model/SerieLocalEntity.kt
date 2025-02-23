package com.example.proyectofinal.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SerieTable)
data class SerieLocalEntity(
    @PrimaryKey val id: Int,
    val title: String?,
    val description: String?,
    val photoUrl: String?,
)

const val SerieTable = "series"
