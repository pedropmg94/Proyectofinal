package com.example.proyectofinal.di

import com.example.proyectofinal.presentation.characterdetails.CharacterDetailViewModel
import com.example.proyectofinal.presentation.characterlist.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
}