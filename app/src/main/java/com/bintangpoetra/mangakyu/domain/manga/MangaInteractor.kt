package com.bintangpoetra.mangakyu.domain.manga

import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.data.manga.MangaRepository
import com.bintangpoetra.mangakyu.domain.manga.model.Manga
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class MangaInteractor(
    private val repository: MangaRepository
) : MangaUseCase {

    override fun getMangaList(): Flow<Results<List<Manga>>> {
        return repository.getMangaList()
            .flowOn(Dispatchers.IO)
    }

    override fun getMangaDetail(id: String): Flow<Results<Manga>> {
        return repository.getMangaDetail(id)
            .flowOn(Dispatchers.IO)
    }

}