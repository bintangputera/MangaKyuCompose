package com.bintangpoetra.mangakyu.base

import android.app.Application
import com.bintangpoetra.mangakyu.di.feature.animeModule
import com.bintangpoetra.mangakyu.di.feature.mangaModule
import com.bintangpoetra.mangakyu.di.networkModule
import com.bintangpoetra.mangakyu.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MangaKyuApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MangaKyuApp)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    animeModule,
                    mangaModule
                )
            )
        }
    }

}