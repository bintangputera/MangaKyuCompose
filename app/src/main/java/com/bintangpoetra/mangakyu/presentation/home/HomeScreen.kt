package com.bintangpoetra.mangakyu.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.bintangpoetra.mangakyu.R
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = getViewModel()
) {

    LaunchedEffect(Unit) {
        homeViewModel.getAnimeList()
        homeViewModel.getMangaList()
    }

    Column {
        Text(text = stringResource(R.string.label_new_release))

    }
}