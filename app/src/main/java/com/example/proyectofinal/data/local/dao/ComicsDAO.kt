package com.example.proyectofinal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.data.local.model.ComicLocalEntity
import com.example.proyectofinal.data.local.model.ComicTable

@Dao
interface ComicsDAO {

    @Query("SELECT * FROM $ComicTable")
    suspend fun getComics(): List<ComicLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveComics(comics: List<ComicLocalEntity>)
}