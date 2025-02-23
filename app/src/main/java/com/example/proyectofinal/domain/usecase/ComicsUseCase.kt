package com.example.proyectofinal.domain.usecase

import com.example.proyectofinal.data.repository.ComicRepository
import com.example.proyectofinal.domain.model.ComicModel

class ComicsUseCase(
    private val comicRepository: ComicRepository
) {

    suspend fun invoke() : List<ComicModel> {
        val localComics = comicRepository.getLocalComics()

        return localComics.ifEmpty {
            val remoteComics = comicRepository.getRemoteComics()
            comicRepository.saveComics(remoteComics)
            remoteComics
        }
    }
}
