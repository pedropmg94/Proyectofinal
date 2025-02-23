package com.example.proyectofinal.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.proyectofinal.presentation.common.extension.ZERO

@Entity(tableName = "FavTable")
data class FavLocalEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int = Int.ZERO,
    @ColumnInfo(name = "favorite") val favorite: Boolean
)