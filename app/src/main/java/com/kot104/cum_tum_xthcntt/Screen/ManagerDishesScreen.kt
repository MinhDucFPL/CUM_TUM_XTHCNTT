package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME

@Composable
fun ManagerDishScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff252121))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar()
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                CustomButton(
                    text = "Thêm món ăn",
                    iconId = R.drawable.logo,
                    onClick = { navController.navigate(ROUTE_SCREEN_NAME.ADDDISHES.name) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    text = "Sửa món ăn",
                    iconId = R.drawable.logo,
                    onClick = { navController.navigate(ROUTE_SCREEN_NAME.EDITDISHES.name) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    text = "Xoá món ăn",
                    iconId = R.drawable.logo,
                    onClick = { navController.navigate(ROUTE_SCREEN_NAME.DELETEDISHES.name) }
                )
            }
        }
    }
}
