package com.example.proyectofinal.data.remote

import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.ComicDTO
import com.example.proyectofinal.data.remote.dto.SerieDTO

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

    override suspend fun getComicList(): ComicDTO =
        marvelAPI.getComicList(APIKEY, TS, HASH, 100, 0)

    override suspend fun getSerieList(): SerieDTO =
        marvelAPI.getSerieList(APIKEY, TS, HASH, 100, 0)
}