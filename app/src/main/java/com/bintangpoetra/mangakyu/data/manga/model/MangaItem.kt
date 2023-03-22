package com.bintangpoetra.mangakyu.data.manga.model

import com.bintangpoetra.mangakyu.data.attributes.model.AttributesItem
import com.google.gson.annotations.SerializedName

data class MangaItem(
    @SerializedName("id")
    val id: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("attributes")
    val attributes: AttributesItem?
)
