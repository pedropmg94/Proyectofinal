package com.example.proyectofinal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.data.local.model.SerieLocalEntity
import com.example.proyectofinal.data.local.model.SerieTable

@Dao
interface SeriesDAO {

    @Query("SELECT * FROM $SerieTable")
    suspend fun getSeries(): List<SerieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSeries(comics: List<SerieLocalEntity>)
}