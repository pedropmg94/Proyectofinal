package com.example.proyectofinal.data.remote

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


}
