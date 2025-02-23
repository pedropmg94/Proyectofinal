package com.example.proyectofinal.data.mappers

import com.example.proyectofinal.data.remote.dto.Thumbnail
import com.example.proyectofinal.presentation.common.extension.EMPTY_STRING

fun getPhoto(thumbnail: Thumbnail?) : String? {
    val separator = if (!thumbnail?.path.isNullOrEmpty() && !thumbnail?.extension.isNullOrEmpty()) Dot else String.EMPTY_STRING
    val photo = "${thumbnail?.path.orEmpty()}$separator${thumbnail?.extension.orEmpty()}"
    return if (photo.contains(NotImage)) null else photo
}

private const val Dot = "."
private const val NotImage = "image_not_available"
