package com.example.proyectofinal.data.repository

import android.util.Log
import com.example.proyectofinal.data.mappers.toCharacterModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.CharacterModel

class CharacterRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    //private val localDataSource: LocalDataSource
): CharacterRepository {
    override suspend fun getCharacterList(): List<CharacterModel> {
        val remoteData = remoteDataSource.getCharacterList()
        return remoteData.data?.results?.map { it.toCharacterModel() } ?: listOf()
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel {
        val remoteData = remoteDataSource.getCharacterDetail(id)
        val result = remoteData.data?.results?.firstOrNull()
        return result?.toCharacterModel() ?: CharacterModel(0, "", "", "")
    }
}