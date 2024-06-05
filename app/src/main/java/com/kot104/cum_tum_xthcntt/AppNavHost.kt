package com.kot104.cum_tum_xthcntt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kot104.cum_tum_xthcntt.Screen.AddDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.BottomNavigation
import com.kot104.cum_tum_xthcntt.Screen.DeleteDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.LoginScreen
import com.kot104.cum_tum_xthcntt.Screen.UpdateDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.WelcomeScreen
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

enum class ROUTE_SCREEN_NAME {
    WELCOME,
    LOGIN,
    HOME,
    MANAGE,
    MANAGECATEGORIES,
    MANAGEDISHES,
    ADDCATEGORY,
    EDITCATEGORY,
    UPDATECATEGORY,
    DELETECATEGORY,
    ADDDISHES,
    EDITDISHES,
    UPDATEDISHES,
    DELETEDISHES
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screens.ManChao.screen,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.ManChao.screen) {
            WelcomeScreen(navController)
        }
        composable(Screens.DangNhap.screen) {
            LoginScreen(navController = navController)
        }
        composable(Screens.TrangChu.screen) {
            BottomNavigation(navController = navController)
        }
        composable(Screens.ThemMonAn.screen) {
            AddDishesScreen(navController = navController)
        }
        composable(Screens.SuaMonAn.screen) {
            UpdateDishesScreen(navController = navController)
        }
        composable(Screens.XoaMonAn.screen) {
            DeleteDishesScreen(navController = navController)
        }
    }
}