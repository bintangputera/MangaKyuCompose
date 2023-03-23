package com.bintangpoetra.mangakyu.ui.navigation

import androidx.annotation.DrawableRes

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val screenRoute: ScreenRoute
)
