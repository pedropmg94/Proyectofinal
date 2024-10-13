package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.mappers.toComicModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.ComicModel

class ComicRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    //private val localDataSource: LocalDataSource
): ComicRepository {
    override suspend fun getComicList(): List<ComicModel> {
        val remoteData = remoteDataSource.getComicList()
        return remoteData.data.results.map { it.toComicModel() } ?: listOf()
    }
}