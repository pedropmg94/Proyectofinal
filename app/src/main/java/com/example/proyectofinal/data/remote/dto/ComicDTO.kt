package com.example.proyectofinal.data.remote.dto

data class ComicDTO(
    /*val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,*/
    val `data`: Data,
    /*val etag: String,
    val status: String*/
)

data class ComicData(
    /*val count: Int,
    val limit: Int,
    val offset: Int,*/
    val results: List<ComicResult>,
    //val total: Int
)

data class ComicResult(
    val characters: Characters,
    val collectedIssues: List<CollectedIssue>,
    val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: Events,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: ComicsSeries,
    val stories: ComicsStories,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Variant>
)

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class CollectedIssue(
    val name: String,
    val resourceURI: String
)

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)

data class Date(
    val date: String,
    val type: String
)

data class Image(
    val extension: String,
    val path: String
)

data class Price(
    val price: Double,
    val type: String
)

data class ComicsSeries(
    val name: String,
    val resourceURI: String
)

data class ComicsStories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)

data class TextObject(
    val language: String,
    val text: String,
    val type: String
)

data class Variant(
    val name: String,
    val resourceURI: String
)
