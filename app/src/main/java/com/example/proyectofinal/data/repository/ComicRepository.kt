package com.example.proyectofinal.data.repository

import com.example.proyectofinal.domain.model.ComicModel

interface ComicRepository {
    suspend fun getRemoteComics(): List<ComicModel>
    suspend fun getLocalComics(): List<ComicModel>
    suspend fun saveComics(comics : List<ComicModel>)
    //suspend fun getCharacterDetail(id: Int): CharacterModel
}