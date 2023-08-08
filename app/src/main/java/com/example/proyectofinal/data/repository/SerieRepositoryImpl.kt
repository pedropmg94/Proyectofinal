package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.mappers.toSerieModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.SerieModel

class SerieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    //private val localDataSource: LocalDataSource
): SerieRepository {
    override suspend fun getSerieList(): List<SerieModel> {
        val remoteData = remoteDataSource.getSerieList()
        return remoteData.data?.results?.map { it.toSerieModel() } ?: listOf()
    }
}