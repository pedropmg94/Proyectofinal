package com.example.proyectofinal.data.remote

import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.ComicDTO
import com.example.proyectofinal.data.remote.dto.SerieDTO

interface RemoteDataSource {
    suspend fun getCharacterList(): CharacterDTO
    suspend fun getCharacterDetail(id: Int): CharacterDTO
    suspend fun getComicList(): ComicDTO
    suspend fun getSerieList(): SerieDTO
 }
