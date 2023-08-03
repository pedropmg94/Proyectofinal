package com.example.proyectofinal.data.remote

import com.example.proyectofinal.domain.model.CharacterModel

class RemoteDataSourceImpl(): RemoteDataSource {
    override suspend fun getCharacterList(): List<CharacterModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel {
        TODO("Not yet implemented")
    }
}