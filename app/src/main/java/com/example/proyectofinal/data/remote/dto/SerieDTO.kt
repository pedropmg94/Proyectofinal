package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class SerieDTO(
    /*val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,*/
    @Json(name = "data") val data: SerieData?,
    /*val etag: String,
    val status: String*/
)

data class SerieData(
    /*@Json(name = "count") val count: Int?,
    @Json(name = "limit") val limit: Int?,
    @Json(name = "offset") val offset: Int?,*/
    @Json(name = "results") val results: List<SerieResult>?,
    //@Json(name = "total") val total: Int?
)

data class SerieResult(
    @Json(name = "characters") val characters: SerieCharacters?,
    @Json(name = "comics") val comics: SerieComics?,
    @Json(name = "creators") val creators: SerieCreators?,
    @Json(name = "description") val description: String?,
    @Json(name = "endYear") val endYear: Int?,
    @Json(name = "events") val events: SerieEvents?,
    @Json(name = "id") val id: Int?,
    @Json(name = "modified") val modified: String?,
    @Json(name = "next") val next: Next?,
    @Json(name = "previous") val previous: Any?,
    @Json(name = "rating") val rating: String?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "startYear") val startYear: Int?,
    @Json(name = "stories") val stories: SerieStories?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
    @Json(name = "title") val title: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "urls") val urls: List<Url>?
)

data class SerieCharacters(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class SerieComics(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class SerieCreators(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemXX>?,
    @Json(name = "returned") val returned: Int?
)

data class SerieEvents(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Any>?,
    @Json(name = "returned") val returned: Int?
)

data class Next(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class SerieStories(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemXXX>?,
    @Json(name = "returned") val returned: Int?
)
