package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.local.model.FavLocalEntity
import com.example.proyectofinal.domain.model.FavModel

fun FavLocalEntity.toFavModel() = FavModel(
    id = id,
    favorite = favorite
)

fun FavModel.toFavLocal() = FavLocalEntity(
    id = id,
    favorite = favorite
)
