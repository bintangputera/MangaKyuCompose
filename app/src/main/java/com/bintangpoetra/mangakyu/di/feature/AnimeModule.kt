package com.bintangpoetra.mangakyu.di.feature

import com.bintangpoetra.mangakyu.data.anime.AnimeDataStore
import com.bintangpoetra.mangakyu.data.anime.AnimeRepository
import com.bintangpoetra.mangakyu.data.anime.remote.AnimeService
import com.bintangpoetra.mangakyu.domain.anime.AnimeInteractor
import com.bintangpoetra.mangakyu.domain.anime.AnimeUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val animeModule = module {

    factory<AnimeUseCase> { AnimeInteractor(get()) }
    factory<AnimeRepository> { AnimeDataStore(get()) }

    single { AnimeDataStore(get()) }
    single { AnimeInteractor(get()) }

    single { provideAnimeService(get()) }

}

fun provideAnimeService(retrofit: Retrofit): AnimeService =
    retrofit.create(AnimeService::class.java)