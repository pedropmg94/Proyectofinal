package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.local.model.FavLocal
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.SerieResult
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.domain.model.FavModel
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.extension.EMPTY_STRING
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


fun ComicResult.toComicModel(): ComicModel? {
    val photo = getPhoto(thumbnail)
    return if (!photo.isNullOrEmpty()) {
        ComicModel(
            id = id ?: Int.ZERO,
            title = title.orEmpty(),
            description = description.orEmpty(),
            photoURL = photo
        )
    } else null
}

fun SerieResult.toSerieModel(): SerieModel? {
    val photo = getPhoto(thumbnail)
    return if (!photo.isNullOrEmpty()) {
        SerieModel(
            id = id ?: Int.ZERO,
            title = title.orEmpty(),
            description = description.orEmpty(),
            photoURL = photo
        )
    } else null
}

fun FavLocal.toFavModel() = FavModel(
    id = id,
    favorite = favorite
)

fun FavModel.toFavLocal() = FavLocal(
    id = id,
    favorite = favorite
)

private fun getPhoto(thumbnail: Thumbnail?) : String? {
    val separator = if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()) Dot else String.EMPTY_STRING
    val photo = "${thumbnail?.path.orEmpty()}$separator${thumbnail?.extension.orEmpty()}"
    return if (photo.contains(NotImage)) null else photo
}

private const val Dot = "."
private const val NotImage = "image_not_available"
