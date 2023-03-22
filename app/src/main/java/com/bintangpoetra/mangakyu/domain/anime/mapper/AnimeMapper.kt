package com.bintangpoetra.mangakyu.domain.anime.mapper

import com.bintangpoetra.mangakyu.data.anime.model.AnimeItem
import com.bintangpoetra.mangakyu.domain.anime.model.Anime
import com.bintangpoetra.mangakyu.domain.attributes.mapper.toDomain
import com.bintangpoetra.mangakyu.domain.attributes.model.Attributes
import com.bintangpoetra.mangakyu.utils.ext.emptyString

fun AnimeItem.toDomain(): Anime {
    return Anime(
        id = id ?: emptyString(),
        type = type ?: emptyString(),
        attributes = attributes?.toDomain() ?: Attributes()
    )
}

fun List<AnimeItem>.toDomain(): List<Anime> {
    return this.map {
        it.toDomain()
    }
}