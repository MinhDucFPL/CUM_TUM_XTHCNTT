package com.kot104.cum_tum_xthcntt.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kot104.cum_tum_xthcntt.Model.Dishes
import com.kot104.cum_tum_xthcntt.R


@Preview
@Composable
fun ProductSection(){
    LazyColumn {items(dishesLists.size) { index ->
        ProductItem(index)
    }
    }
}

@Composable
fun ProductItem(index: Int){
    val dis = dishesLists[index]
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xff2F2D2D)),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
//                        painter = painterResource(id = dis.image)
                        painter = painterResource(id = R.drawable.img_food),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = dis.name, color = Color.White)
                        Text(text = "${dis.price} K" ,color = Color(0xffFFB703), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}