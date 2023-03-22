package com.bintangpoetra.mangakyu.domain.attributes.mapper

import com.bintangpoetra.mangakyu.data.attributes.model.AttributesItem
import com.bintangpoetra.mangakyu.domain.attributes.model.Attributes
import com.bintangpoetra.mangakyu.domain.coverimage.mapper.toDomain
import com.bintangpoetra.mangakyu.domain.coverimage.model.CoverImage
import com.bintangpoetra.mangakyu.utils.ext.emptyString
import com.bintangpoetra.mangakyu.utils.ext.orZero

fun AttributesItem.toDomain(): Attributes {
    return Attributes(
        createdAt = createdAt ?: emptyString(),
        updatedAt = updatedAt ?: emptyString(),
        slug = slug ?: emptyString(),
        synopsis = synopsis ?: emptyString(),
        description = description ?: emptyString(),
        canonicalTitle = canonicalTitle ?: emptyString(),
        averageRating = averageRating ?: emptyString(),
        userCount = userCount.orZero(),
        favoritesCount = favoritesCount.orZero(),
        ageRating = ageRating ?: emptyString(),
        ageRatingGuide = ageRatingGuide ?: emptyString(),
        coverImage = coverImage?.toDomain() ?: CoverImage(),
    )
}