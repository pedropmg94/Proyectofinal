package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.CharacterRepository

class GetCharacterDetailUseCase(private val characterRepository: CharacterRepository) {
    suspend fun invoke(id: Int) = characterRepository.getCharacterDetail(id)
}