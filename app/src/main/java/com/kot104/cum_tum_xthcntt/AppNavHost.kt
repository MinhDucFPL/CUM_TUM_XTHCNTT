package com.kot104.cum_tum_xthcntt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kot104.cum_tum_xthcntt.Screen.BottomNavigation
import com.kot104.cum_tum_xthcntt.Screen.HomeScreen
import com.kot104.cum_tum_xthcntt.Screen.LoginScreen
import com.kot104.cum_tum_xthcntt.Screen.StatisticalScreen
import com.kot104.cum_tum_xthcntt.Screen.WelcomeScreen

enum class ROUTE_SCREEN_NAME {
    WELCOME,
    LOGIN,
    HOME,
    STATISTICAL,
    MANAGE,
    SUPPORT
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ROUTE_SCREEN_NAME.WELCOME.name,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_SCREEN_NAME.WELCOME.name) {
            WelcomeScreen(navController)
        }
        composable(ROUTE_SCREEN_NAME.LOGIN.name) {
            LoginScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.HOME.name) {
            BottomNavigation(navControl = navController)
        }
    }
}