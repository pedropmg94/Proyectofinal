package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.local.model.FavLocal
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.SerieResult
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.model.SerieModel

fun CharacterResult.toCharacterModel(favModel: FavModel) = CharacterModel(
    id = id ?: 0,
    name = name ?: "",
    //description = description ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    photoURL =
    "${thumbnail?.path ?: ""}${if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()) "." else ""}${thumbnail?.extension ?: ""}",
    favModel = favModel
)

fun ComicResult.toComicModel() = ComicModel(
    id = id ?: 0,
    title = title ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    //photoURL = "${thumbnail?.path ?: ""}.${thumbnail?.extension ?: ""}" ?: ""
    photoURL =
    "${thumbnail?.path ?: ""}${if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()) "." else ""}${thumbnail?.extension ?: ""}"

)

fun SerieResult.toSerieModel() = SerieModel(
    id = id ?: 0,
    title = title ?: "",
    description = if (description.isNullOrEmpty()) "No description" else description,
    //photoURL = "${thumbnail?.path ?: ""}.${thumbnail?.extension ?: ""}" ?: ""
    photoURL =
    "${thumbnail?.path ?: ""}${if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()) "." else ""}${thumbnail?.extension ?: ""}"

)

fun FavLocal.toFavModel() = FavModel(
    id = id ?: 0,
    favorite = favorite ?: false
)

fun FavModel.toFavLocal() = FavLocal(
    id = id ?: 0,
    favorite = favorite ?: false
)