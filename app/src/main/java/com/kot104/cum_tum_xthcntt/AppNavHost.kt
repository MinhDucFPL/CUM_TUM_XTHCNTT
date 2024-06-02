package com.kot104.cum_tum_xthcntt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kot104.cum_tum_xthcntt.Screen.AddCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.AddDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.BottomNavigation
import com.kot104.cum_tum_xthcntt.Screen.DeleteCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.DeleteDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.EditCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.EditDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.HomeScreen
import com.kot104.cum_tum_xthcntt.Screen.LoginScreen
import com.kot104.cum_tum_xthcntt.Screen.ManageScreen
import com.kot104.cum_tum_xthcntt.Screen.ManagerCategoriesScreen
import com.kot104.cum_tum_xthcntt.Screen.ManagerDishScreen
import com.kot104.cum_tum_xthcntt.Screen.StatisticalScreen
import com.kot104.cum_tum_xthcntt.Screen.UpdateCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.UpdateDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.WelcomeScreen

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
        composable(ROUTE_SCREEN_NAME.MANAGE.name) {
            ManageScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.MANAGECATEGORIES.name) {
            ManagerCategoriesScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.ADDCATEGORY.name) {
            AddCategoryScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.EDITCATEGORY.name) {
            EditCategoryScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.DELETECATEGORY.name) {
            DeleteCategoryScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.UPDATECATEGORY.name) {
            UpdateCategoryScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.MANAGEDISHES.name) {
            ManagerDishScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.ADDDISHES.name) {
            AddDishesScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.EDITDISHES.name) {
            EditDishesScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.UPDATEDISHES.name) {
            UpdateDishesScreen(navController = navController)
        }
        composable(ROUTE_SCREEN_NAME.DELETEDISHES.name) {
            DeleteDishesScreen(navController = navController)
        }
    }
}