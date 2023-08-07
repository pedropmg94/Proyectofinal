package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class SerieDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: SerieData,
    val etag: String,
    val status: String
)

data class SerieData(
    /*@Json(name = "count") val count: Int?,
    @Json(name = "limit") val limit: Int?,
    @Json(name = "offset") val offset: Int?,*/
    @Json(name = "results") val results: List<SerieResult>?,
    //@Json(name = "total") val total: Int?
)

data class SerieResult(
    val characters: SerieCharacters,
    val comics: SerieComics,
    val creators: SerieCreators,
    val description: String,
    val endYear: Int,
    val events: SerieEvents,
    val id: Int,
    val modified: String,
    val next: Next,
    val previous: Any,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val stories: SerieStories,
    val thumbnail: Thumbnail,
    val title: String,
    val type: String,
    val urls: List<Url>
)

data class SerieCharacters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class SerieComics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class SerieCreators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)

data class SerieEvents(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)

data class Next(
    val name: String,
    val resourceURI: String
)

data class SerieStories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)
