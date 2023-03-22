package com.bintangpoetra.mangakyu.data.anime

import com.bintangpoetra.mangakyu.data.anime.remote.AnimeService
import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.domain.anime.mapper.toDomain
import com.bintangpoetra.mangakyu.domain.anime.model.Anime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeDataStore(
    private val service: AnimeService
) : AnimeRepository {

    override fun getAnimeList(): Flow<Results<List<Anime>>> = flow {
        try {
            emit(Results.Loading)

            val response = service.getAnimeList()
            if (response.data.isEmpty()) {
                emit(Results.Empty)
            } else {
                emit(Results.Success(response.data.toDomain()))
            }
        } catch (ex: Exception) {
            emit(Results.Error(ex.message.toString()))
        }
    }

    override fun getAnimeDetail(id: String): Flow<Results<Anime>> = flow {
        try {
            emit(Results.Loading)

            val response = service.getAnimeDetail(id)
            emit(Results.Success(response.data.toDomain()))
        } catch (ex: Exception) {
            emit(Results.Error(ex.message.toString()))
        }
    }

}