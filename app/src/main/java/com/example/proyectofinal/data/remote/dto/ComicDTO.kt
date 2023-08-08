package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

data class ComicDTO(
    /*val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,*/
    @Json(name = "data") val data: ComicData,
    /*val etag: String,
    val status: String*/
)

data class ComicData(
    /*val count: Int,
    val limit: Int,
    val offset: Int,*/
    @Json(name = "results") val results: List<ComicResult>,
    //val total: Int
)

data class ComicResult(
    @Json(name = "characters") val characters: ComicCharacters?,
    @Json(name = "collectedIssues") val collectedIssues: List<CollectedIssue>?,
    @Json(name = "collections") val collections: List<Any>?,
    @Json(name = "creators") val creators: ComicCreators?,
    @Json(name = "dates") val dates: List<Date>?,
    @Json(name = "description") val description: String?,
    @Json(name = "diamondCode") val diamondCode: String?,
    @Json(name = "digitalId") val digitalId: Int?,
    @Json(name = "ean") val ean: String?,
    @Json(name = "events") val events: ComicEvents?,
    @Json(name = "format") val format: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "images") val images: List<Image>?,
    @Json(name = "isbn") val isbn: String?,
    @Json(name = "issn") val issn: String?,
    @Json(name = "issueNumber") val issueNumber: Int?,
    @Json(name = "modified") val modified: String?,
    @Json(name = "pageCount") val pageCount: Int?,
    @Json(name = "prices") val prices: List<Price>?,
    @Json(name = "resourceURI") val resourceURI: String?,
    @Json(name = "series") val series: ComicsSeries?,
    @Json(name = "stories") val stories: ComicsStories?,
    @Json(name = "textObjects") val textObjects: List<TextObject>?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
    @Json(name = "title") val title: String?,
    @Json(name = "upc") val upc: String?,
    @Json(name = "urls") val urls: List<Url>?,
    @Json(name = "variantDescription") val variantDescription: String?,
    @Json(name = "variants") val variants: List<Variant>?
)

data class ComicCharacters(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class CollectedIssue(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class ComicCreators(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemX>?,
    @Json(name = "returned") val returned: Int?
)

data class Date(
    @Json(name = "date") val date: String?,
    @Json(name = "type") val type: String?
)

data class ComicEvents(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Any>?,
    @Json(name = "returned") val returned: Int?
)

data class Image(
    @Json(name = "extension") val extension: String?,
    @Json(name = "path") val path: String?
)

data class Price(
    @Json(name = "price") val price: Double?,
    @Json(name = "type") val type: String?
)

data class ComicsSeries(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class ComicsStories(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemXX>?,
    @Json(name = "returned") val returned: Int?
)

data class TextObject(
    @Json(name = "language") val language: String?,
    @Json(name = "text") val text: String?,
    @Json(name = "type") val type: String?
)

data class Variant(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)