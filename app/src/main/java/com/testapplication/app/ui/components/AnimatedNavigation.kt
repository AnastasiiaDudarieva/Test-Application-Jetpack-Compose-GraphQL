package com.testapplication.app.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.testapplication.app.ui.screens.DetailScreen
import com.testapplication.app.ui.screens.MainScreen
import com.testapplication.app.ui.screens.Screen

@Composable
fun AnimatedNavigation(navController: NavHostController) {

    NavHost(navController, startDestination = Screen.MainScreen.route) {
        composable(
            route = Screen.MainScreen.route,
            enterTransition = {
                return@composable slideInHorizontally(
                    animationSpec = tween(
                        700
                    )
                ) + fadeIn(animationSpec = tween(700))
            },
            exitTransition = {
                return@composable slideOutHorizontally(
                    animationSpec = tween(700)
                ) + fadeOut(animationSpec = tween(700))

            }
        ) {
            MainScreen(onPersonSelected = { person ->
                // Navigate using the ID and Name as separate arguments for clarity
                navController.navigate("${Screen.DetailScreen.route}/${person.id}/${person.name}")
            })
        }
        composable(
            route = "${Screen.DetailScreen.route}/{personId}/{personName}",
            enterTransition = {
                return@composable slideInHorizontally(animationSpec = tween(700)) + fadeIn(
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                return@composable slideOutHorizontally(animationSpec = tween(700)) + fadeOut(
                    animationSpec = tween(700)
                )
            },
            arguments = listOf(
                navArgument("personId") { type = NavType.StringType },
                navArgument("personName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val personId = backStackEntry.arguments?.getString("personId") ?: ""
            val personName = backStackEntry.arguments?.getString("personName") ?: ""

            DetailScreen(navController, personId = personId, personName = personName)
        }
    }
}
