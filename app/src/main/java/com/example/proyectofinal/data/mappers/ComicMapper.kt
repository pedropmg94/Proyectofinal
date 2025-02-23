package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.local.model.ComicLocalEntity
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.domain.model.ComicModel
import com.example.proyectofinal.presentation.common.extension.ZERO

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

fun ComicLocalEntity.toComicModel(): ComicModel =
    ComicModel(
        id = id,
        title = title,
        description = description,
        photoURL = photoUrl
    )

fun toComicEntity(comic: ComicModel): ComicLocalEntity =
    ComicLocalEntity(
        id = comic.id,
        title = comic.title,
        description = comic.description,
        photoUrl = comic.photoURL
    )

