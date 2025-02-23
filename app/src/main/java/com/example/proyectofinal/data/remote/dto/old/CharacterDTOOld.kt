package com.example.proyectofinal.data.remote.dto.old

import com.example.proyectofinal.data.remote.dto.CharacterResult
import com.example.proyectofinal.data.remote.dto.Data
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemXXX
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.squareup.moshi.Json

/*
Estas cases se han obtenido con el plugin Json to Kotlin class.
Se abre y se pega el código que se obtiene en Postman.
Al darle a aplicar nos crea automáticamente las clases.


data class CharacterDTOOld(
    @Json(name = "attributionHTML") val attributionHTML: String?,
    @Json(name = "attributionText") val attributionText: String?,
    @Json(name = "code") val code: Int?,
    @Json(name = "copyright") val copyright: String?,
    @Json(name = "data") val data: Data?,
    @Json(name = "etag") val etag: String?,
    @Json(name = "status") val status: String?
)

data class DataOld(
    @Json(name = "count") val count: Int?,
    @Json(name = "limit") val limit: Int?,
    @Json(name = "offset") val offset: Int?,
    @Json(name = "results") val results: List<CharacterResult>?,
    @Json(name = "total") val total: Int?
)

data class CharacterResultOld(
    @Json(name = "comics") val comics: Comics?,
    @Json(name = "description") val description: String?,
    @Json(name = "events") val events: Events?,
    @Json(name = "id") val id: Int?,
    @Json(name = "modified") val modified: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "series") val series: Series?,
    @Json(name = "stories") val stories: Stories?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
    @Json(name = "urls") val urls: List<Url>?
)

data class ComicsOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class EventsOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class SeriesOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class StoriesOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemXXX>?,
    @Json(name = "returned") val returned: Int?
)
*/