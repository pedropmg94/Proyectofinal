package com.example.proyectofinal.di

import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterDetailUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import com.example.proyectofinal.domain.usecase.ComicsUseCase
import com.example.proyectofinal.domain.usecase.SeriesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterListUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
    single { ComicsUseCase(get()) }
    single { SeriesUseCase(get()) }
    single { FavUseCase(get()) }
}