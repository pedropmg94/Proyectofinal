package com.example.proyectofinal.di

import com.example.proyectofinal.presentation.characterdetails.CharacterDetailViewModel
import com.example.proyectofinal.presentation.characterlist.CharacterListViewModel
import com.example.proyectofinal.presentation.comiclist.ComicListViewModel
import com.example.proyectofinal.presentation.login.LoginViewModel
import com.example.proyectofinal.presentation.serielist.SerieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(get(), get()) }
    viewModel { CharacterDetailViewModel(get()) }
    viewModel { ComicListViewModel(get()) }
    viewModel { SerieListViewModel(get()) }
    viewModel { LoginViewModel() }
}