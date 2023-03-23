package com.bintangpoetra.mangakyu.ui.navigation

sealed class ScreenRoute(val route: String) {
    object Splash : ScreenRoute("splash")
    object Home : ScreenRoute("home")
    object Search : ScreenRoute("search")
    object Favorite : ScreenRoute("favorite")
    object Detail : ScreenRoute("detail/{id}") {
        fun toDetailRoute(id: Int, type: String) = "detail/$type/$id"
    }
}