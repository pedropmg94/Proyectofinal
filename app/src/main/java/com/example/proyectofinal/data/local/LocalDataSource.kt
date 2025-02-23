package com.example.proyectofinal.data.local

import com.example.proyectofinal.data.local.model.ComicLocalEntity
import com.example.proyectofinal.data.local.model.FavLocalEntity
import com.example.proyectofinal.data.local.model.SerieLocalEntity

interface LocalDataSource {
    suspend fun getFav(): List<FavLocalEntity>
    suspend fun setFav(favLocalEntity: FavLocalEntity)
    suspend fun getComics(): List<ComicLocalEntity>
    suspend fun setComics(comics: List<ComicLocalEntity>)
    suspend fun getSeries(): List<SerieLocalEntity>
    suspend fun setSeries(series: List<SerieLocalEntity>)
}
