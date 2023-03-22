package com.bintangpoetra.mangakyu.domain.anime.model

import com.bintangpoetra.mangakyu.domain.attributes.model.Attributes
import com.bintangpoetra.mangakyu.utils.ext.emptyString

data class Anime(
    val id: String = emptyString(),
    val type: String = emptyString(),
    val attributes: Attributes = Attributes()
)