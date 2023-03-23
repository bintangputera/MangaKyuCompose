package com.bintangpoetra.mangakyu.di.feature

import com.bintangpoetra.mangakyu.data.manga.MangaDataStore
import com.bintangpoetra.mangakyu.data.manga.MangaRepository
import com.bintangpoetra.mangakyu.data.manga.remote.MangaService
import com.bintangpoetra.mangakyu.domain.manga.MangaInteractor
import com.bintangpoetra.mangakyu.domain.manga.MangaUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val mangaModule = module {

    factory<MangaUseCase> { MangaInteractor(get()) }
    factory<MangaRepository> { MangaDataStore(get()) }

    single { MangaDataStore(get()) }
    single { MangaInteractor(get()) }

    single { provideMangaService(get()) }

}

fun provideMangaService(retrofit: Retrofit): MangaService =
    retrofit.create(MangaService::class.java)