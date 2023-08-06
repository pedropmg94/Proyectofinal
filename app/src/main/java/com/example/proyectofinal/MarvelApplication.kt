package com.example.proyectofinal

import android.app.Application
import com.example.proyectofinal.di.dataModule
import com.example.proyectofinal.di.domainModule
import com.example.proyectofinal.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MarvelApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            /*
            En modo debug (depuración) mostraré mensajes por consola y de lo contrario no lo haré
             */
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )

            androidContext(this@MarvelApplication)

            modules(
                presentationModule,
                domainModule,
                dataModule
            )

        }
    }
}