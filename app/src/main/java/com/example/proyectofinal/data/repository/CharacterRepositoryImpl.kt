package com.example.proyectofinal.data.repository

import com.example.proyectofinal.data.local.LocalDataSource
import com.example.proyectofinal.data.mappers.toCharacterModel
import com.example.proyectofinal.data.mappers.toFavLocal
import com.example.proyectofinal.data.mappers.toFavModel
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.domain.model.CharacterModel
import com.example.proyectofinal.domain.model.FavModel

class CharacterRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): CharacterRepository {
    override suspend fun getCharacterList(): List<CharacterModel> {
        val remoteData = remoteDataSource.getCharacterList()
        val favList = localDataSource.getFav().map { it.toFavModel() }
        return remoteData.data?.results?.mapNotNull { result ->
            val fav = favList.find { it.id == result.id } ?: FavModel(result.id ?: 0, false)
            result.toCharacterModel(fav)
        } ?: listOf()
    }

    override suspend fun getCharacterDetail(id: Int): CharacterModel {
        val remoteData = remoteDataSource.getCharacterDetail(id)
        val favList = localDataSource.getFav().map { it.toFavModel() }
        val result = remoteData.data?.results?.firstOrNull()
        val fav = favList.find { it.id == result?.id } ?: FavModel(result?.id ?: 0, false)
        return result?.toCharacterModel(fav) ?: CharacterModel(0, "", "", "", fav)
    }

    override suspend fun setFav(favModel: FavModel) {
        localDataSource.setFav(favModel.toFavLocal())
    }
}