package com.example.proyectofinal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectofinal.data.local.dao.ComicsDAO
import com.example.proyectofinal.data.local.dao.FavDao
import com.example.proyectofinal.data.local.dao.SeriesDAO
import com.example.proyectofinal.data.local.model.ComicLocalEntity
import com.example.proyectofinal.data.local.model.FavLocalEntity
import com.example.proyectofinal.data.local.model.SerieLocalEntity

@Database(
    entities = [FavLocalEntity::class, ComicLocalEntity::class, SerieLocalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MarvelDataBase : RoomDatabase() {
    abstract fun favDao(): FavDao
    abstract fun comicsDao() : ComicsDAO
    abstract fun seriesDao() : SeriesDAO
}