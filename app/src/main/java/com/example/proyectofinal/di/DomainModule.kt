package com.example.proyectofinal.di

import com.example.proyectofinal.domain.usecase.GetCharacterDetailUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterListUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
}