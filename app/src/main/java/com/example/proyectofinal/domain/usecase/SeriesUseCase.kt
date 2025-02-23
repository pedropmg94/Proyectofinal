package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.SerieRepository
import com.example.proyectofinal.domain.model.SerieModel

class SeriesUseCase(
    private val serieRepository: SerieRepository
) {

    suspend fun invoke() : List<SerieModel> {
        val localSeries = serieRepository.getLocalSeries()
        return localSeries.ifEmpty {
            val remoteSeries = serieRepository.getRemoteSeries()
            serieRepository.saveSeries(remoteSeries)
            remoteSeries
        }
    }
}
