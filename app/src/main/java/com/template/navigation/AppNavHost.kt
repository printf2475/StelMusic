package com.template.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.template.component.NavigationBar
import com.template.feature.home.navigate.HomeRoute
import com.template.feature.home.navigate.homeScreen
import com.template.feature.home.navigate.navigateToHome


@Composable
internal fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                navController = navController,
                destinations = MainDestination.entries.toList(),
                onClick = { destination ->
                    when (destination) {
                        MainDestination.Home -> navController.navigateToHome()
                        else -> Unit
                    }

                }
            )
        }
    ) {
        NavHost(
            modifier = Modifier
                .padding(it)
                .zIndex(1f),
            startDestination = HomeRoute,
            navController = navController,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            homeScreen()
        }
    }
}