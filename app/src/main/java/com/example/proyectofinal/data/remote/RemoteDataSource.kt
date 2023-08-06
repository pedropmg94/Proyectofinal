package com.example.proyectofinal.data.remote

import com.example.proyectofinal.domain.model.CharacterModel

interface RemoteDataSource {
    suspend fun getCharacterList(): CharacterDTO
    suspend fun getCharacterDetail(id: Int): CharacterDTO
 }
