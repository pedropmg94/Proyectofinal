package com.example.proyectofinal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectofinal.data.local.model.FavLocal


@Database(entities = [FavLocal::class], version = 1, exportSchema = false)
abstract class FavDataBase : RoomDatabase() {
    abstract fun favDao(): FavDao
}