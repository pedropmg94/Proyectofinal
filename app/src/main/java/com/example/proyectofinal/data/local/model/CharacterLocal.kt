package com.example.proyectofinal.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharacterTable")
data class CharacterLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photoUrl") val photoUrl: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean
)