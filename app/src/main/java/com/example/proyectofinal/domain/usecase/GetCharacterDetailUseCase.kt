package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.CharacterRepository
import com.example.proyectofinal.domain.model.CharacterModel

class GetCharacterDetailUseCase(
    private val characterRepository: CharacterRepository
    ) {
    suspend fun invoke(id: Int) = characterRepository.getCharacterDetail(id)
}