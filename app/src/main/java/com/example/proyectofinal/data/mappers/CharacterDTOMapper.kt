package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.remote.dto.Result
import com.example.proyectofinal.domain.model.CharacterModel

fun Result.toCharacterModel() = CharacterModel(
    id = id ?: 0,
    name = name ?: "",
    //description = description ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    photoURL = "${thumbnail?.path}.${thumbnail?.extension}" ?: ""
)