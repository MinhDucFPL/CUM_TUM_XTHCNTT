package com.kot104.cum_tum_xthcntt.Screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.compose.OderSection


@Composable
//navController: NavHostController
fun HomeScreen(navController: NavHostController){
    var date:String
    var soluong:Int
    var doanhthu:Int
    date="01-06-2024"
    soluong=2
    doanhthu=320000
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff252121))){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement =  Arrangement.SpaceBetween

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription ="",
                modifier = Modifier.width(60.dp))

            Text(
                text = "Cum tứm đim",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
            IconButton(
                onClick = { }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier
            .height(5.dp)
            .fillMaxWidth()
            .background(Color.Black))
        Column (
            Modifier.padding(top = 30.dp)
        ) {
            Text(
                text = "Today: $date",
                fontSize = 20.sp,
                color = Color.White,
            )
            Text(
                text = "Số lượng đơn: $soluong",
                fontSize = 20.sp,
                color = Color.White
            )
            Row {
                Text(
                    text = "Doanh Thu: ",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "$doanhthu đ",
                    fontSize = 20.sp,
                    color = Color(0xffFE724C)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        OderSection()
    }
    }
}