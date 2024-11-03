package com.example.proyectofinal

import android.app.Application
import com.example.proyectofinal.di.dataModule
import com.example.proyectofinal.di.domainModule
import com.example.proyectofinal.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarvelApplication)

            modules(
                presentationModule,
                domainModule,
                dataModule
            )

        }
    }
}