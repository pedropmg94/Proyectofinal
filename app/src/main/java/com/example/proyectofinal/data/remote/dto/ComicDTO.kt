package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class ComicDTO(
    @Json(name = "data") val data: ComicData,
)

data class ComicData(
    @Json(name = "results") val results: List<ComicResult>,
)

data class ComicResult(
    @Json(name = "description") val description: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
    @Json(name = "title") val title: String?,
)
