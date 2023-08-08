package com.example.proyectofinal.data.remote

import com.example.proyectofinal.data.remote.dto.CharacterDTO
import com.example.proyectofinal.data.remote.dto.ComicDTO
import com.example.proyectofinal.data.remote.dto.SerieDTO
import com.example.proyectofinal.data.remote.dto.StorieDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MarvelAPI {
    @GET("v1/public/characters")
    suspend fun getCharacerList(
        @Query("apikey") apikey: String,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): CharacterDTO

    @GET("v1/public/characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int,
        @Query("apikey") apikey: String,
        @Query("ts") ts: Int,
        @Query("hash") hash: String
    ): CharacterDTO

    @GET("v1/public/comics")
    suspend fun getComicList(
        @Query("apikey") apikey: String,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ComicDTO

    @GET("v1/public/series")
    suspend fun getSerieList(
        @Query("apikey") apikey: String,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): SerieDTO

    @GET("v1/public/stories")
    suspend fun getStorieList(
        @Query("apikey") apikey: String,
        @Query("ts") ts: Int,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): StorieDTO
}
