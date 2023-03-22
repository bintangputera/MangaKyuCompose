package com.bintangpoetra.mangakyu.data.anime.remote

import com.bintangpoetra.mangakyu.data.anime.model.AnimeItem
import com.bintangpoetra.mangakyu.data.lib.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {

    @GET("anime")
    fun getAnimeList(): BaseResponse<List<AnimeItem>>

    @GET("anime/{id}")
    fun getAnimeDetail(
        @Path("id") animeId: String
    ): BaseResponse<AnimeItem>

}