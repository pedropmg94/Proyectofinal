package com.example.proyectofinal.di

import com.example.proyectofinal.domain.usecase.FavUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterDetailUseCase
import com.example.proyectofinal.domain.usecase.GetCharacterListUseCase
import com.example.proyectofinal.domain.usecase.GetComicListUseCase
import com.example.proyectofinal.domain.usecase.GetSerieListUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterListUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
    single { GetComicListUseCase(get()) }
    single { GetSerieListUseCase(get()) }
    single { FavUseCase(get()) }
}