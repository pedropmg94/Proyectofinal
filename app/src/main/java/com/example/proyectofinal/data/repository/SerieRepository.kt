package com.example.proyectofinal.data.repository

import com.example.proyectofinal.domain.model.SerieModel

interface SerieRepository {
    suspend fun getRemoteSeries(): List<SerieModel>
    suspend fun getLocalSeries(): List<SerieModel>
    suspend fun saveSeries(series : List<SerieModel>)
}