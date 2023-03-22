package com.bintangpoetra.mangakyu.data.anime

import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.domain.anime.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun getAnimeList(): Flow<Results<List<Anime>>>

    fun getAnimeDetail(id: String): Flow<Results<Anime>>

}