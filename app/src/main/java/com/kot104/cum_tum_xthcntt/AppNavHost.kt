package com.kot104.cum_tum_xthcntt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kot104.cum_tum_xthcntt.Screen.admin.AddCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.AddDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.BottomNavigation
import com.kot104.cum_tum_xthcntt.Screen.admin.DeleteCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.DeleteDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.LoginScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.Register
import com.kot104.cum_tum_xthcntt.Screen.admin.UpdateCategoryScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.UpdateDishesScreen
import com.kot104.cum_tum_xthcntt.Screen.admin.WelcomeScreen
import com.kot104.cum_tum_xthcntt.compose.CategoryDeleteSection
import com.kot104.cum_tum_xthcntt.compose.CategorySection
import com.kot104.cum_tum_xthcntt.compose.DishesEditSection
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
        composable(Screens.Register.screen){
            Register(navControl = navController)
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
        composable(Screens.DanhSachSuaMonAn.screen) {
            DishesEditSection(navController = navController)
        }
        composable(Screens.DanhSachSuaLoaiMonAn.screen) {
            CategorySection(navController = navController)
        }
        composable(Screens.ThemLoaiMonAn.screen) {
            AddCategoryScreen(navController = navController)
        }
        composable(Screens.SuaLoaiMonAn.screen) {
            UpdateCategoryScreen(navController = navController)
        }
        composable(Screens.XoaLoaiMonAn.screen) {
            DeleteCategoryScreen(navController = navController)
        }
        composable(Screens.DanhSachXoaMon.screen) {
            CategoryDeleteSection(navController = navController)
        }
    }
}