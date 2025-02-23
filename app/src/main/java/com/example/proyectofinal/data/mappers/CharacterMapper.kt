package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.presentation.common.extension.ZERO

fun CharacterResult.toCharacterModel(favModel: FavModel): CharacterModel? {
    val photo = getPhoto(thumbnail)

    return if (!photo.isNullOrEmpty()) {
        CharacterModel(
            id = id ?: Int.ZERO,
            name = name.orEmpty(),
            description = description.orEmpty(),
            photoURL = photo,
            favModel = favModel
        )
    } else null
}
