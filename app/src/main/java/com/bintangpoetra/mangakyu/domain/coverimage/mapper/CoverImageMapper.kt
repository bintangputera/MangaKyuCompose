package com.bintangpoetra.mangakyu.domain.coverimage.mapper

import com.bintangpoetra.mangakyu.data.coverimage.CoverImageItem
import com.bintangpoetra.mangakyu.domain.coverimage.model.CoverImage
import com.bintangpoetra.mangakyu.utils.ext.emptyString

fun CoverImageItem.toDomain(): CoverImage {
    return CoverImage(
        original = this.original ?: emptyString()
    )
}