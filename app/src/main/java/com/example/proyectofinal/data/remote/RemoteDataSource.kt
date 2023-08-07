package com.example.proyectofinal.data.remote

import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.ComicDTO

interface RemoteDataSource {
    suspend fun getCharacterList(): CharacterDTO
    suspend fun getCharacterDetail(id: Int): CharacterDTO
    suspend fun getComicList(): ComicDTO
 }
