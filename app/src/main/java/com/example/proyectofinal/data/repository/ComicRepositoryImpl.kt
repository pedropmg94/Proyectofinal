package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.local.LocalDataSource
import com.example.proyectofinal.data.mappers.toComicEntity
import com.example.proyectofinal.data.mappers.toComicModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.ComicModel

class ComicRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ComicRepository {

    override suspend fun getRemoteComics(): List<ComicModel> {
        val remoteData = remoteDataSource.getComicList()
        return remoteData.data.results.mapNotNull { it.toComicModel() }
    }

    override suspend fun getLocalComics(): List<ComicModel> {
        val localComics = localDataSource.getComics()
        return localComics.map { it.toComicModel() }
    }

    override suspend fun saveComics(comics: List<ComicModel>) {
        val comicsLocal = comics.map {
            toComicEntity(it)
        }
        localDataSource.setComics(comicsLocal)
    }
}