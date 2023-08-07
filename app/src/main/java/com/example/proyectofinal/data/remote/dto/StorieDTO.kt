package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class StorieDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: StorieData,
    val etag: String,
    val status: String
)

data class StorieData(
    /*@Json(name = "count") val count: Int?,
    @Json(name = "limit") val limit: Int?,
    @Json(name = "offset") val offset: Int?,*/
    @Json(name = "results") val results: List<StorieResult>?,
    //@Json(name = "total") val total: Int?
)

data class StorieResult(
    val characters: StorieCharacters,
    val comics: StorieComics,
    val creators: StorieCreators,
    val description: String,
    val events: StorieEvents,
    val id: Int,
    val modified: String,
    val originalIssue: OriginalIssue,
    val resourceURI: String,
    val series: StorieSeries,
    val thumbnail: Any,
    val title: String,
    val type: String
)

data class StorieCharacters(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)

data class StorieComics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class StorieCreators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)

data class StorieEvents(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)

data class OriginalIssue(
    val name: String,
    val resourceURI: String
)

data class StorieSeries(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
