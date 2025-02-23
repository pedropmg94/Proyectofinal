package com.example.proyectofinal.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.data.local.model.FavLocalEntity

@Dao
interface FavDao {

    @Query("SELECT * FROM FavTable")
    suspend fun getFavorites(): List<FavLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(vararg favLocalEntity: FavLocalEntity)

}