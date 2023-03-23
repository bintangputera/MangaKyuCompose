package com.bintangpoetra.mangakyu.domain.manga

import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.domain.manga.model.Manga
import kotlinx.coroutines.flow.Flow

interface MangaUseCase {

    fun getMangaList(): Flow<Results<List<Manga>>>

    fun getMangaDetail(id: String): Flow<Results<Manga>>

}