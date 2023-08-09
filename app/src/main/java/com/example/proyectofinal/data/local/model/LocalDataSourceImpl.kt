package com.example.proyectofinal.data.local.model

import com.example.proyectofinal.data.local.FavDataBase
import com.example.proyectofinal.data.local.LocalDataSource

class LocalDataSourceImpl(private val db: FavDataBase): LocalDataSource {
    override suspend fun getFav(): List<FavLocal> =
        db.favDao().getFavorites()

    override suspend fun setFav(favLocal: FavLocal) {
        db.favDao().insertFavorites(favLocal)
    }
}
