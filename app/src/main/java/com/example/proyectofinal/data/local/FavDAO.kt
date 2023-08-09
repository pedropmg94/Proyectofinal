package com.example.proyectofinal.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.data.local.model.FavLocal

@Dao
interface FavDao {

    @Query("SELECT * FROM FavTable")
    suspend fun getFavorites(): List<FavLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(vararg favLocal: FavLocal)

}