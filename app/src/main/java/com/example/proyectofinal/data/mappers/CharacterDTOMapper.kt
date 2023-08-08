package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.SerieResult
import com.example.proyectofinal.data.remote.dto.StorieResult
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.domain.model.StorieModel

fun CharacterResult.toCharacterModel() = CharacterModel(
    id = id ?: 0,
    name = name ?: "",
    //description = description ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    photoURL = "${thumbnail?.path}.${thumbnail?.extension}" ?: ""
)

fun ComicResult.toComicModel() = ComicModel(
    id = id ?: 0,
    title = title ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    photoURL = "${thumbnail?.path}.${thumbnail?.extension}" ?: ""
)

fun SerieResult.toSerieModel() = SerieModel(
    id = id ?: 0,
    title = title ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    photoURL = "${thumbnail?.path}.${thumbnail?.extension}" ?: ""
)