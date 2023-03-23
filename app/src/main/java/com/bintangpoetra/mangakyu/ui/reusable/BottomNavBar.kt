package com.bintangpoetra.mangakyu.ui.reusable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bintangpoetra.mangakyu.R
import com.bintangpoetra.mangakyu.ui.navigation.NavigationItem
import com.bintangpoetra.mangakyu.ui.navigation.ScreenRoute
import com.bintangpoetra.mangakyu.ui.theme.Grey200

@Composable
fun BottomNavBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        BottomNavigation(
            backgroundColor = Grey200,
            contentColor = Grey200
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val navigationItem = listOf(
                NavigationItem(
                    icon = R.drawable.ic_home,
                    title = stringResource(R.string.menu_home),
                    screenRoute = ScreenRoute.Home
                ),
                NavigationItem(
                    icon = R.drawable.ic_search,
                    title = stringResource(R.string.menu_search),
                    screenRoute = ScreenRoute.Search
                ),
                NavigationItem(
                    icon = R.drawable.ic_favorite,
                    title = stringResource(R.string.menu_favorite),
                    screenRoute = ScreenRoute.Favorite
                )
            )

            BottomNavigation {
                navigationItem.map { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                            )
                        },
                        selectedContentColor = Color(0XFFFFFF0E),
                        unselectedContentColor = Color.White,
                        label = { Text(text = item.title) },
                        selected = currentRoute == item.screenRoute.route,
                        onClick = {

                        }
                    )
                }
            }
        }
    }

}