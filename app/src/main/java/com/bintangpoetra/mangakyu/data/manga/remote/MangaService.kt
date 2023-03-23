package com.bintangpoetra.mangakyu.data.manga.remote

import com.bintangpoetra.mangakyu.data.lib.BaseResponse
import com.bintangpoetra.mangakyu.data.manga.model.MangaItem
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaService {

    @GET("manga")
    fun getMangaList(): BaseResponse<List<MangaItem>>

    @GET("manga/{id}")
    fun getMangaDetail(
        @Path("id") id: String
    ): BaseResponse<MangaItem>

}