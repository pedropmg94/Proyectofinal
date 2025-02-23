package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class SerieDTO(
    @Json(name = "data") val data: SerieData?,
)

data class SerieData(
    @Json(name = "results") val results: List<SerieResult>?,
)

data class SerieResult(
    @Json(name = "description") val description: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
    @Json(name = "title") val title: String?,
)
