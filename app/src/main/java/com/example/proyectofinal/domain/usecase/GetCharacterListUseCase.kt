package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.CharacterRepository

class GetCharacterListUseCase(private val characterRepository: CharacterRepository) {
    suspend fun invoke() = characterRepository.getCharacterList()
}