package com.example.proyectofinal.data.local

import com.example.proyectofinal.data.local.model.ComicLocalEntity
import com.example.proyectofinal.data.local.model.FavLocalEntity
import com.example.proyectofinal.data.local.model.SerieLocalEntity

class LocalDataSourceImpl(
    private val db: MarvelDataBase
): LocalDataSource {
    override suspend fun getFav(): List<FavLocalEntity> =
        db.favDao().getFavorites()

    override suspend fun setFav(favLocalEntity: FavLocalEntity) =
        db.favDao().insertFavorites(favLocalEntity)

    override suspend fun getComics(): List<ComicLocalEntity> =
        db.comicsDao().getComics()

    override suspend fun setComics(comics: List<ComicLocalEntity>) =
        db.comicsDao().saveComics(comics)

    override suspend fun getSeries(): List<SerieLocalEntity> =
        db.seriesDao().getSeries()

    override suspend fun setSeries(series: List<SerieLocalEntity>) =
        db.seriesDao().saveSeries(series)
}
