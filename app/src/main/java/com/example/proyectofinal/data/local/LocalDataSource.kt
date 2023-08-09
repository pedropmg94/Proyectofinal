package com.example.proyectofinal.data.local

import com.example.proyectofinal.data.local.model.FavLocal
import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.ComicDTO
import com.example.proyectofinal.data.remote.dto.SerieDTO

interface LocalDataSource {

    suspend fun getFav(): List<FavLocal>
    suspend fun setFav(favLocal: FavLocal)
}
