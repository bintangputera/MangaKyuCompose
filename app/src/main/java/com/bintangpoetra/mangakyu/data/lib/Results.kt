package com.bintangpoetra.mangakyu.data.lib

sealed class Results<out R> {
    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val errorMessage: String) : Results<Nothing>()
    object Loading : Results<Nothing>()
    object Empty : Results<Nothing>()
}
