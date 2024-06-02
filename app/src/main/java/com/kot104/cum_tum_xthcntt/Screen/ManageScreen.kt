package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME

@Composable
fun ManageScreen(navController: NavHostController) {
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
                    text = "Quản lý loại món ăn",
                    iconId = R.drawable.logo,
                    onClick = { navController.navigate(ROUTE_SCREEN_NAME.MANAGECATEGORIES.name) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    text = "Quản lý món ăn",
                    iconId = R.drawable.logo,
                    onClick = { navController.navigate(ROUTE_SCREEN_NAME.MANAGEDISHES.name) }
                )
            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    iconId: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        colors = ButtonDefaults.buttonColors(Color(0xff2F2D2D)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            )
        }
    }
}
