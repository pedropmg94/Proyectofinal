package com.example.proyectofinal.di

import com.example.proyectofinal.data.remote.MarvelAPI
import com.example.proyectofinal.data.remote.RemoteDataSource
import com.example.proyectofinal.data.remote.RemoteDataSourceImpl
import com.example.proyectofinal.data.repository.CharacterRepository
import com.example.proyectofinal.data.repository.CharacterRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*
Inyección de dependencias con Koin:

1. dataModule es el módulo principal que contiene todas las declaraciones de inyección de dependencias.
Se configura utilizando la función module de Koin.

2. OkHttpClient es un cliente HTTP de OkHttp.
En este caso, se configura con un interceptor de registro para registrar las solicitudes y respuestas HTTP en la consola para fines de depuración.

3. Retrofit es una biblioteca utilizada para realizar solicitudes HTTP a servicios web.
Se configura con la URL base de la API, el cliente OkHttp y un convertidor Moshi para analizar las respuestas JSON.

4. Moshi es una biblioteca para serializar y deserializar objetos JSON.
Se configura con un adaptador de Kotlin para trabajar con objetos Kotlin.

 */

const val BaseURL = "https://gateway.marvel.com/"

val dataModule = module {

    /*OkhttpClient
    .addInterceptor(...): Se agrega un interceptor al cliente.
    Un interceptor es una clase que puede interceptar y modificar solicitudes y respuestas antes de que se envíen o reciban.

    HttpLoggingInterceptor(...): Se crea una instancia de HttpLoggingInterceptor,
    que se utiliza para registrar información sobre las solicitudes y respuestas HTTP para fines de depuración.

    .apply { ... }: Se utiliza el método apply para configurar las propiedades de HttpLoggingInterceptor.
    En este caso, se establece el nivel de log a HttpLoggingInterceptor.Level.BODY,
    lo que significa que se registrarán los cuerpos de las solicitudes y respuestas en el registro.
     */
    single {
        OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    /* Retrofit
    .baseUrl("https://dragonball.keepcoding.education/"): Aquí se establece la URL base para todas las solicitudes a la API.
    Cuando se realice una solicitud a una ruta específica, se combinará con esta URL base.

    .client(get()): Aquí se obtiene una instancia de OkHttpClient utilizando la función get().
    Koin proporcionará una instancia de OkHttpClient que fue declarada previamente en el módulo de inyección de dependencias.

    .addConverterFactory(MoshiConverterFactory.create(get())):
    Se agrega un convertidor de fábrica para manejar la conversión entre JSON y objetos Kotlin utilizando la biblioteca Moshi.
    Nuevamente, se utiliza la función get() para obtener una instancia de Moshi que se declaró previamente en el módulo.
     */
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BaseURL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    /* Moshi
    .addLast(KotlinJsonAdapterFactory()): Aquí se agrega un adaptador a la instancia de Moshi.
    El adaptador KotlinJsonAdapterFactory es un adaptador especializado que se encarga de serializar
    y deserializar objetos Kotlin en formato JSON.
     */
    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<MarvelAPI> { getMarvelAPI(get()) }
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }

}

private fun getMarvelAPI(retrofit: Retrofit) =
    retrofit.create(MarvelAPI::class.java)
