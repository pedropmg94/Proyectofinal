package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.local.model.SerieLocalEntity
import com.example.proyectofinal.data.remote.dto.SerieResult
import com.example.proyectofinal.domain.model.SerieModel
import com.example.proyectofinal.presentation.common.extension.ZERO

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

fun SerieLocalEntity.toSerieModel(): SerieModel =
    SerieModel(
        id = id,
        title = title.orEmpty(),
        description = description.orEmpty(),
        photoURL = photoUrl.orEmpty()
    )

fun toSerieEntity(serie: SerieModel): SerieLocalEntity =
    SerieLocalEntity(
        id = serie.id,
        title = serie.title,
        description = serie.description,
        photoUrl = serie.photoURL
    )
