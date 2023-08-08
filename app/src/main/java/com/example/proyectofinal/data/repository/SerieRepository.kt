package com.example.proyectofinal.data.repository

import com.example.proyectofinal.domain.model.SerieModel

interface SerieRepository {
    suspend fun getSerieList(): List<SerieModel>
    //suspend fun getCharacterDetail(id: Int): CharacterModel
}