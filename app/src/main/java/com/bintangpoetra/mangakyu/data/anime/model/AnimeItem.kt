package com.bintangpoetra.mangakyu.data.anime.model

import com.bintangpoetra.mangakyu.data.attributes.model.AttributesItem
import com.google.gson.annotations.SerializedName

data class AnimeItem(
    @SerializedName("id")
    val id: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("attributes")
    val attributes: AttributesItem?
)