package com.kot104.cum_tum_xthcntt.compose

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.Model.StatisticalModel
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
val StatisticalLists = listOf(
    StatisticalModel("21220554","03/03/2023","09:53",57,true),
    StatisticalModel("21220553","03/03/2023","09:53",57,true),
    StatisticalModel("21220554","03/03/2023","09:53",57,true),
    StatisticalModel("21220553","03/03/2023","09:53",57,true),
    StatisticalModel("21220554","03/03/2023","09:53",57,true),
    StatisticalModel("21220553","03/03/2023","09:53",57,true)
)
@Preview
@Composable
fun StatisticalSection(){
    LazyColumn {
        items(StatisticalLists.size) { index ->
            StatisticalItem(index)
        }
    }
}
@Composable
fun StatisticalItem(index: Int){
    val sta = StatisticalLists[index]
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff2F2D2D), shape = RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "ID ${sta.id}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${sta.date}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${sta.time}",
                        color = Color(0xffFE724C),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Column (
                    modifier = Modifier.padding(20.dp)
                ) {
                    if(sta.TrangThai=== false){
                        Text(
                            text = "Từ chối",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }else{
                        Text(
                            text = "Hoàn thành",
                            color = Color.Green,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${sta.id} đ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

            }
        }
    }
}
