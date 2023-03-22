package com.bintangpoetra.mangakyu.data.lib

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    val data: T
)