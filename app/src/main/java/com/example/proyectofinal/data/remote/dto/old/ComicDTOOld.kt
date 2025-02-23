package com.example.proyectofinal.data.remote.dto.old

import com.example.proyectofinal.data.remote.dto.ComicData
import com.example.proyectofinal.data.remote.dto.ComicResult
import com.example.proyectofinal.data.remote.dto.Item
import com.example.proyectofinal.data.remote.dto.ItemX
import com.example.proyectofinal.data.remote.dto.ItemXX
import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.squareup.moshi.Json

/*
data class ComicDTOOld(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @Json(name = "data") val data: ComicData,
    val etag: String,
    val status: String
)

data class ComicDataOld(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @Json(name = "results") val results: List<ComicResult>,
    val total: Int
)

data class ComicResultOld(
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

data class ComicCharactersOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Item>?,
    @Json(name = "returned") val returned: Int?
)

data class CollectedIssueOld(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class ComicCreatorsOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemX>?,
    @Json(name = "returned") val returned: Int?
)

data class DateOld(
    @Json(name = "date") val date: String?,
    @Json(name = "type") val type: String?
)

data class ComicEventsOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<Any>?,
    @Json(name = "returned") val returned: Int?
)

data class ImageOld(
    @Json(name = "extension") val extension: String?,
    @Json(name = "path") val path: String?
)

data class PriceOld(
    @Json(name = "price") val price: Double?,
    @Json(name = "type") val type: String?
)

data class ComicsSeriesOld(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)

data class ComicsStoriesOld(
    @Json(name = "available") val available: Int?,
    @Json(name = "collectionURI") val collectionURI: String?,
    @Json(name = "items") val items: List<ItemXX>?,
    @Json(name = "returned") val returned: Int?
)

data class TextObjectOld(
    @Json(name = "language") val language: String?,
    @Json(name = "text") val text: String?,
    @Json(name = "type") val type: String?
)

data class VariantOld(
    @Json(name = "name") val name: String?,
    @Json(name = "resourceURI") val resourceURI: String?
)
*/
