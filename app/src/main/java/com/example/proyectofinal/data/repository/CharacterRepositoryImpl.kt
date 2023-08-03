package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.CharacterModel

class CharacterRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    //private val localDataSource: LocalDataSource
): CharacterRepository {
    override suspend fun getCharacterList(): List<CharacterModel> {
        return remoteDataSource.getCharacterList()
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel {
        return remoteDataSource.getCharacterDetail(id)
    }
}