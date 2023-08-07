package com.example.proyectofinal.data.repository

import com.example.proyectofinal.domain.model.ComicModel

interface ComicRepository {
    suspend fun getComicList(): List<ComicModel>
    //suspend fun getCharacterDetail(id: Int): CharacterModel
}