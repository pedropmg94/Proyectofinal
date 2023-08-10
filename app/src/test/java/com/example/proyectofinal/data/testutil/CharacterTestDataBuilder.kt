package com.example.proyectofinal.data.testutil

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel

class CharacterTestDataBuilder {
    val id = 1
    var name = ""
    var photoURL = ""
    var description = ""
    lateinit var favModel: FavModel
    var numElements: Int = 15

    fun withName(name: String): CharacterTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoURL(photoURL: String): CharacterTestDataBuilder {
        this.photoURL = photoURL
        return this
    }

    fun withDescription(description: String): CharacterTestDataBuilder {
        this.description = description
        return this
    }

    fun withNumElements(numElements: Int): CharacterTestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun withFavModel(favModel: FavModel): CharacterTestDataBuilder {
        this.favModel = favModel
        return this
    }

    fun buildList(): List<CharacterModel> {
        val list = mutableListOf<CharacterModel>()

        for(i in 0 until numElements) {
            list.add(
                CharacterModel(
                    id,
                    name = name,
                    description = description,
                    photoURL = photoURL,
                    favModel = favModel
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = CharacterModel(
        id = id,
        name = name,
        description = description,
        photoURL = photoURL,
        favModel = favModel
    )
}

