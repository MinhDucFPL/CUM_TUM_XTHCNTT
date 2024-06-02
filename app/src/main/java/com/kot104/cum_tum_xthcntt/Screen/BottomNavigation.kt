package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.compose.rememberNavController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@Composable
fun BottomNavigation(navControl: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MyBottomAppBar(navControl)
    }
}

@Composable
fun MyBottomAppBar(navControl: NavHostController) {
    val navigationController = rememberNavController()
    val selected = rememberSaveable { mutableStateOf("home") }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.shadow(8.dp),
                containerColor = Color(0xFF312C2C)
            ) {
                BottomNavigationItem(
                    selected = selected.value == "home",
                    onClick = {
                        selected.value = "home"
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(Screens.Home.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "home") R.drawable.ic_home else R.drawable.ic_home_outlined
                    ),
                    text = "Trang chủ",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "statistical",
                    onClick = {
                        selected.value = "statistical"
                        navigationController.navigate(Screens.Statistical.screen) {
                            popUpTo(Screens.Statistical.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "statistical") R.drawable.ic_shopping_cart else R.drawable.ic_shopping_cart_outlined
                    ),
                    text = "Thống kê",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "manage",
                    onClick = {
                        selected.value = "manage"
                        navigationController.navigate(Screens.Manage.screen) {
                            popUpTo(Screens.Manage.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "manage") R.drawable.ic_manage else R.drawable.ic_manage_outlined
                    ),
                    text = "Quản lý",
                    selectedColor = Color.Yellow,
                    unselectedColor = Color.White,
                    modifier = Modifier.weight(1f)
                )

                BottomNavigationItem(
                    selected = selected.value == "support",
                    onClick = {
                        selected.value = "support"
                        navigationController.navigate(Screens.Support.screen) {
                            popUpTo(Screens.Support.screen) { inclusive = true }
                        }
                    },
                    icon = painterResource(
                        id = if (selected.value == "support") R.drawable.ic_support else R.drawable.ic_support_outlined
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
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { HomeScreen(navControl) }
            composable(Screens.Statistical.screen) { StatisticalScreen(navControl) }
            composable(Screens.Manage.screen) { ManageScreen(navControl) }
            composable(Screens.Support.screen) { SupportScreen(navControl) }
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
