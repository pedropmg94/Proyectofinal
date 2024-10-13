package com.example.proyectofinal.di

import com.example.proyectofinal.presentation.screens.characterdetails.CharacterDetailViewModel
import com.example.proyectofinal.presentation.screens.characterlist.CharacterListViewModel
import com.example.proyectofinal.presentation.screens.comiclist.ComicListViewModel
import com.example.proyectofinal.presentation.screens.login.LoginViewModel
import com.example.proyectofinal.presentation.screens.serielist.SerieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get(), get()) }
    viewModel { CharacterDetailViewModel(get()) }
    viewModel { ComicListViewModel(get()) }
    viewModel { SerieListViewModel(get()) }
    viewModel { LoginViewModel() }
}