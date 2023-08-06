package com.example.proyectofinal.data.remote

import com.example.proyectofinal.domain.model.CharacterModel

class RemoteDataSourceImpl(
    private val marvelAPI: MarvelAPI
): RemoteDataSource {

    private val APIKEY = "0b7870d1147ffec101c8240107afcf96"
    private val HASH = "dabc3843eb8a028ca6a9d88758daedc4"
    private val TS = 1

    override suspend fun getCharacterList(): CharacterDTO =
        marvelAPI.getCharacerList(APIKEY, TS, HASH, 100, 0)


    override suspend fun getCharacterDetail(id: Int): CharacterDTO =
        marvelAPI.getCharacterDetail(id, APIKEY, TS, HASH)
}