package com.bintangpoetra.mangakyu.data.manga

import com.bintangpoetra.mangakyu.data.lib.Results
import com.bintangpoetra.mangakyu.data.manga.remote.MangaService
import com.bintangpoetra.mangakyu.domain.manga.mapper.toDomain
import com.bintangpoetra.mangakyu.domain.manga.model.Manga
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MangaDataStore(
    private val service: MangaService
) : MangaRepository {

    override fun getMangaList(): Flow<Results<List<Manga>>> = flow {
        try {
            emit(Results.Loading)

            val response = service.getMangaList()
            if (response.data.isEmpty()) {
                emit(Results.Empty)
            } else {
                emit(Results.Success(response.data.toDomain()))
            }
        } catch (ex: Exception) {
            emit(Results.Error(ex.message.toString()))
        }
    }

    override fun getMangaDetail(id: String): Flow<Results<Manga>> = flow {
        try {
            emit(Results.Loading)

            val response = service.getMangaDetail(id)
            emit(Results.Success(response.data.toDomain()))
        } catch (ex: Exception) {
            emit(Results.Error(ex.message.toString()))
        }
    }

}