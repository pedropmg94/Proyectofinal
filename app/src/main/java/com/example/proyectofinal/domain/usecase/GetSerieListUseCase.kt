package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.SerieRepository

class GetSerieListUseCase(
    private val serieRepository: SerieRepository
    ) {
    suspend fun invoke() = serieRepository.getSerieList()
}