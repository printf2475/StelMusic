package com.stelmusic.navigation

import androidx.annotation.DrawableRes
import com.stelmusic.R
import com.stelmusic.feature.home.navigate.HomeRoute
import kotlin.reflect.KClass

enum class MainDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: KClass<*>,
) {
    Home(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = HomeRoute::class
    ),
    Home1(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = HomeRoute::class
    ),
    Home2(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = HomeRoute::class
    ),
    Home3(
        selectedIcon = R.drawable.ic_launcher_foreground,
        unselectedIcon = R.drawable.ic_launcher_foreground,
        route = HomeRoute::class
    ),
}