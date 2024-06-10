package com.kot104.cum_tum_xthcntt.Screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R


@Composable
//navController: NavHostController
fun SupportScreen(navController: NavHostController){
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
            TopAppBar()
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
                .background(Color.Black))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row ( modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.zalo), contentDescription = "",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xffF5F5F5))
                        .clickable { },
                )
                Text(text = "0346677855",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically))
            }
            Row (modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.email), contentDescription = "",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xffF5F5F5))
                        .clickable { },
                )
                Text(text = "duclm.fpl.work@gmail.com", fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically))
            }
            Row (modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.phone), contentDescription = "",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xffF5F5F5))
                        .clickable { },
                )
                Text(text = "duclm.fpl.work@gmail.com", fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically))
            }

        }
    }
}