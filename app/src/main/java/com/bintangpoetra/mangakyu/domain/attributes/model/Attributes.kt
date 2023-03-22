package com.bintangpoetra.mangakyu.domain.attributes.model

import com.bintangpoetra.mangakyu.domain.coverimage.model.CoverImage
import com.bintangpoetra.mangakyu.utils.ext.emptyString

data class Attributes(
    val createdAt: String = emptyString(),
    val updatedAt: String? = emptyString(),
    val slug: String? = emptyString(),
    val synopsis: String = emptyString(),
    val description: String? = emptyString(),
    val canonicalTitle: String = emptyString(),
    val averageRating: String? = emptyString(),
    val userCount: Int = 0,
    val favoritesCount: Int = 0,
    val ageRating: String = emptyString(),
    val ageRatingGuide: String = emptyString(),
    val coverImage: CoverImage = CoverImage(),
    val episodeCount: Int = 0,
    val episodeLength: Int = 0
)
