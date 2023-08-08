package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.ComicRepository

class GetComicListUseCase(
    private val comicRepository: ComicRepository
    ) {
    suspend fun invoke() = comicRepository.getComicList()
}