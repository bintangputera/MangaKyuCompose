package com.bintangpoetra.mangakyu.domain.manga.mapper

import com.bintangpoetra.mangakyu.data.manga.model.MangaItem
import com.bintangpoetra.mangakyu.domain.attributes.mapper.toDomain
import com.bintangpoetra.mangakyu.domain.attributes.model.Attributes
import com.bintangpoetra.mangakyu.domain.manga.model.Manga
import com.bintangpoetra.mangakyu.utils.ext.emptyString

fun MangaItem.toDomain(): Manga {
    return Manga(
        id = id ?: emptyString(),
        type = type ?: emptyString(),
        attributes = attributes?.toDomain() ?: Attributes()
    )
}

fun List<MangaItem>.toDomain(): List<Manga> {
    return this.map {
        it.toDomain()
    }
}