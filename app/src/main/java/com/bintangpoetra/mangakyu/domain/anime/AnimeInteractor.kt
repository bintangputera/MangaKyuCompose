package com.bintangpoetra.mangakyu.domain.anime

import com.bintangpoetra.mangakyu.data.anime.AnimeRepository
import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.domain.anime.model.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class AnimeInteractor(
    private val repository: AnimeRepository
): AnimeUseCase {

    override fun getAnimeList(): Flow<Results<List<Anime>>> {
        return repository.getAnimeList()
            .flowOn(Dispatchers.IO)
    }

    override fun getAnimeDetail(id: String): Flow<Results<Anime>> {
        return repository.getAnimeDetail(id)
            .flowOn(Dispatchers.IO)
    }

}