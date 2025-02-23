package com.example.proyectofinal.data.remote.dto

import com.squareup.moshi.Json

/*
Estas cases se han obtenido con el plugin Json to Kotlin class.
Se abre y se pega el código que se obtiene en Postman.
Al darle a aplicar nos crea automáticamente las clases.
 */

data class CharacterDTO(
    @Json(name = "data") val data: Data?,
)

data class Data(
    @Json(name = "results") val results: List<CharacterResult>?,
)

data class CharacterResult(
    @Json(name = "description") val description: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?,
)
