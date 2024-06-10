package com.kot104.cum_tum_xthcntt.Screen.user

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
import androidx.compose.foundation.layout.width
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
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.compose.CategoriesSection
import com.kot104.cum_tum_xthcntt.compose.CategoryProduct
import com.kot104.cum_tum_xthcntt.compose.ProductSection

@Preview
@Composable
//navController: NavHostController
fun UserHome(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff252121))){
        Column(modifier = Modifier
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff312F2E)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
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
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.poster),
                    contentDescription ="",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Column (
                ) {
                }
                Spacer(modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(Color.Black))
            }
            CategoriesSection()
            ProductSection()
        }
    }

}