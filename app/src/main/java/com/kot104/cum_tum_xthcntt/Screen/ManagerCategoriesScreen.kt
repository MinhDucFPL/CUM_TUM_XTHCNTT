package com.kot104.cum_tum_xthcntt.Screen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R


@Composable
//navController: NavHostController
fun ManagerCategoriesScreen(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff252121))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
                TopAppBar()
            }
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
                    text = "Thêm loại món ăn",
                    iconId = R.drawable.logo,
                    onClick =  {navController.navigate("AddCategory")}
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    text = "Sửa loại món ăn",
                    iconId = R.drawable.logo,
                    onClick = {navController.navigate("EditCategory")}
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(
                    text = "Xoá loại món ăn",
                    iconId = R.drawable.logo,
                    onClick = {navController.navigate("DeleteCategory")}
                )
            }
        }
    }
}