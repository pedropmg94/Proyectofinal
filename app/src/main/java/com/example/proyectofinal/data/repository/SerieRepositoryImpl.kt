package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.local.LocalDataSource
import com.example.proyectofinal.data.mappers.toSerieEntity
import com.example.proyectofinal.data.mappers.toSerieModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.SerieModel

class SerieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): SerieRepository {

    override suspend fun getRemoteSeries(): List<SerieModel> {
        val remoteData = remoteDataSource.getSerieList()
        return remoteData.data?.results?.mapNotNull { it.toSerieModel() } ?: listOf()
    }

    override suspend fun getLocalSeries(): List<SerieModel> {
        val seriesLocal = localDataSource.getSeries()
        return seriesLocal.map { it.toSerieModel() }
    }

    override suspend fun saveSeries(series: List<SerieModel>) {
        val seriesLocal = series.map { toSerieEntity(it) }
        localDataSource.setSeries(seriesLocal)
    }
}