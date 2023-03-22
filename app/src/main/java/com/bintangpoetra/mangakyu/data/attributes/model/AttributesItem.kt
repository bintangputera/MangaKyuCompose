package com.bintangpoetra.mangakyu.data.attributes.model

import com.bintangpoetra.mangakyu.data.coverimage.CoverImageItem

data class AttributesItem(
    val createdAt: String?,
    val updatedAt: String?,
    val slug: String?,
    val synopsis: String?,
    val description: String?,
    val canonicalTitle: String?,
    val averageRating: String?,
    val userCount: Int?,
    val favoritesCount: Int?,
    val ageRating: String?,
    val ageRatingGuide: String?,
    val coverImage: CoverImageItem?,
    val episodeCount: Int?,
    val episodeLength: Int?
)
