package com.bintangpoetra.mangakyu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bintangpoetra.mangakyu.presentation.home.HomeScreen
import com.bintangpoetra.mangakyu.ui.navigation.ScreenRoute
import com.bintangpoetra.mangakyu.ui.reusable.BottomNavBar
import com.bintangpoetra.mangakyu.ui.theme.MangaKyuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MangaKyuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    when (currentRoute) {
        ScreenRoute.Splash.route -> {
            bottomBarState.value = false
        }
        ScreenRoute.Home.route -> {
            bottomBarState.value = true
        }
        ScreenRoute.Search.route -> {
            bottomBarState.value = true
        }
        ScreenRoute.Favorite.route -> {
            bottomBarState.value = true
        }
        ScreenRoute.Detail.route -> {
            bottomBarState.value = true
        }
    }
    Scaffold(bottomBar = {
        if (bottomBarState.value) {
            BottomNavBar(navController = navController)
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenRoute.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenRoute.Home.route) {
                HomeScreen(navController = navController)
            }
        }
    }
}