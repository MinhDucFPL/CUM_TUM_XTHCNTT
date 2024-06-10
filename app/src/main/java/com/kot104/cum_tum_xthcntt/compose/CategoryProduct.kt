package com.kot104.cum_tum_xthcntt.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.Chair
import androidx.compose.material.icons.outlined.ChairAlt
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.TableBar
import androidx.compose.material.icons.rounded.Bed
import androidx.compose.material.icons.rounded.Chair
import androidx.compose.material.icons.rounded.ChairAlt
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.TableBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kot104.cum_tum_xthcntt.Model.Categories
import com.kot104.cum_tum_xthcntt.R

class CategoryProduct() {
}

val items = listOf(
    Categories(1, "Món ăn", Icons.Outlined.Star, true),
    Categories(2, "Đồ ăn thêm", Icons.Outlined.ChairAlt, false),
    Categories(3, "Topping", Icons.Outlined.TableBar, false),
    Categories(4, "Khác", Icons.Outlined.Bed, false),


    )
@Preview
@Composable
fun CategoriesSection () {
    LazyRow(modifier = Modifier
        .padding(10.dp)
        .background(Color(0xff252121))
        .padding(5.dp)) {
        items(items.size) { index ->
            CategoryItem(index)
        }
    }
}


@Composable
fun CategoryItem(index: Int) {
    val category = items[index]
    val itemWidth = 90.dp // Set a fixed width for each item
    val padding = 16.dp
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ){
        if(category.isSelected==true){
            Text(
                text = category.name,
                fontSize = 10.sp,
                color = Color(0xffFFB703),
                fontWeight = FontWeight.Bold
            )
        } else Text(
            text = category.name,
            fontSize = 10.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Box(

        ) {
            Column(
                // Add padding inside the item for better spacing
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally

            ) {
                Image(painter = painterResource(id = R.drawable.img_food), contentDescription = "",
                    modifier = Modifier
                        .width(itemWidth)
                        .height(90.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xffF5F5F5))
                        .clickable { },
                    )
                Spacer(Modifier.height(8.dp))
            }
        }
    }

}