package com.example.proyectofinal.data.repository

import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel

//https://gateway.marvel.com/v1/public/characters?apikey=0b7870d1147ffec101c8240107afcf96&ts=1&hash=dabc3843eb8a028ca6a9d88758daedc4

interface CharacterRepository {
    suspend fun getCharacterList(): List<CharacterModel>
    suspend fun getCharacterDetail(id: Int): CharacterModel
    suspend fun setFav(favModel: FavModel)
 }
