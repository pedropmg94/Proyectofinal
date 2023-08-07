package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class Thumbnail(
    @Json(name = "extension") val extension: String?,
    @Json(name = "path") val path: String?
)

data class Url(
    @Json(name = "type") val type: String?,
    @Json(name = "url") val url: String?
)

data class Item(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class ItemX(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "role") val role: String?
)

data class ItemXX(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "type") val type: String?
)

data class ItemXXX(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "type") val type: String?
)