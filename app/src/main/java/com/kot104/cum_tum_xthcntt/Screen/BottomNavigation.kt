package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
import com.kot104.cum_tum_xthcntt.compose.DishesEditSection
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@Composable
fun QuanLyNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.QuanLy.screen,
        modifier = modifier
    ) {
        composable(Screens.QuanLy.screen) {
            ManageScreen(navController)
        }
        composable(Screens.QuanLyMonAn.screen) {
            ManagerDishScreen(navController)
        }
        composable(Screens.QuanLyLoaiMonAn.screen) {
            ManagerCategoriesScreen(navController)
        }
        composable(Screens.ThemMonAn.screen) {
            AddDishesScreen(navController)
        }
        composable(Screens.DanhSachSuaMonAn.screen) {
            DishesEditSection(navController)
        }
        composable(Screens.SuaMonAn.screen) {
            UpdateDishesScreen(navController)
        }
        composable(Screens.XoaMonAn.screen) {
            DeleteDishesScreen(navController)
        }
        composable(Screens.ThemLoaiMonAn.screen) {
            AddCategoryScreen(navController)
        }
        composable(Screens.SuaLoaiMonAn.screen) {
            UpdateCategoryScreen(navController)
        }
        composable(Screens.XoaLoaiMonAn.screen) {
            DeleteCategoryScreen(navController)
        }
    }
}
@Composable
fun BottomNavigation(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MyBottomAppBar(navController)
    }
}

@Composable
fun MyBottomAppBar(navController: NavHostController) {
    val navigationController = rememberNavController()
    val selected = rememberSaveable { mutableStateOf(Screens.TrangChu.screen) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.shadow(8.dp),
                containerColor = Color(0xFF312C2C)
            ) {
                BottomNavigationItem(
                    selected = selected.value == Screens.TrangChu.screen,
                    onClick = {
                        selected.value = Screens.TrangChu.screen
                        navigationController.navigate(Screens.TrangChu.screen) {
                            popUpTo(Screens.TrangChu.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == Screens.TrangChu.screen) R.drawable.ic_home else R.drawable.ic_home_outlined
                    ),
                    text = "Trang chủ",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "ThongKe",
                    onClick = {
                        selected.value = "ThongKe"
                        navigationController.navigate(Screens.ThongKe.screen) {
                            popUpTo(Screens.ThongKe.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "ThongKe") R.drawable.ic_shopping_cart else R.drawable.ic_shopping_cart_outlined
                    ),
                    text = "Thống kê",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "QuanLy",
                    onClick = {
                        selected.value = "QuanLy"
                        navigationController.navigate(Screens.QuanLy.screen) {
                            popUpTo(Screens.QuanLy.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "QuanLy") R.drawable.ic_manage else R.drawable.ic_manage_outlined
                    ),
                    text = "Quản lý",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "HoTro",
                    onClick = {
                        selected.value = "HoTro"
                        navigationController.navigate(Screens.HoTro.screen) {
                            popUpTo(Screens.HoTro.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "HoTro") R.drawable.ic_support else R.drawable.ic_support_outlined
                    ),
                    text = "Support",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.TrangChu.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.TrangChu.screen) { HomeScreen(navController) }
            composable(Screens.ThongKe.screen) { StatisticalScreen(navController) }
            composable(Screens.QuanLy.screen) { QuanLyNavHost() }
            composable(Screens.HoTro.screen) { SupportScreen(navController) }
//            composable(Screens.QuanLyMonAn.screen) { QuanLyMonAnNavHost(navController) }
        }
    }
}

@Composable
fun BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: Painter,
    text: String,
    selectedColor: Color,
    unselectedColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        IconButton(onClick = onClick) {
            Icon(
                painter = icon,
                contentDescription = text,
                modifier = Modifier.size(24.dp),
                tint = if (selected) selectedColor else unselectedColor
            )
        }
        Text(
            text = text,
            color = if (selected) selectedColor else unselectedColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
