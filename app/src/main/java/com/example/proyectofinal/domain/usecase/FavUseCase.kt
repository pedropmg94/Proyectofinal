package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.CharacterRepository
import com.example.proyectofinal.domain.model.FavModel

class FavUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend fun invoke(favModel: FavModel) = characterRepository.setFav(favModel)
}