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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.kot104.cum_tum_xthcntt.Model.Dishes
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
import com.kot104.cum_tum_xthcntt.ui.theme.Screens


val dishesLists= listOf(
    Dishes(1," ", categoryLists[0],"Sườn bì",28),
    Dishes(2," ", categoryLists[1],"Bì chả",25),
    Dishes(3," ", categoryLists[2],"Trứng chả",29),
    Dishes(4," ", categoryLists[0],"Sườn chả",22),
    Dishes(5," ", categoryLists[1],"Sườn bì chả",38),
    Dishes(6," ", categoryLists[2],"Sườn cây",45),
    Dishes(7," ", categoryLists[1],"Sườn trứng",38),
    Dishes(8," ", categoryLists[2],"Cơm rang",20)
)

@Composable
//navController: NavHostController
fun DishesEditSection(navController: NavHostController){
    LazyColumn {
        items(dishesLists.size) { index ->
            //,navController
            DishesEditItem(index,navController)
            if (index < dishesLists.size - 1) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
@Composable
//navController: NavHostController
fun DishesEditItem(index: Int,navController: NavHostController){
    val dis = dishesLists[index]
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 2.dp, bottom = 2.dp),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color(0xff2F2D2D), shape = RoundedCornerShape(10.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${dis.id}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
//                AsyncImage(
//                    model = dis.image,
//                    contentDescription = null,
//                    contentScale = ContentScale.FillWidth,
//                    modifier = Modifier
//                        .wrapContentHeight()
//                        .fillMaxWidth()
//                )
                Image(painter = painterResource(id = R.drawable.img_food), contentDescription ="" , modifier = Modifier.width(60.dp).height(60.dp).padding(5.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "${dis.name} ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "${dis.price} K",
                        color = Color(0xffFE724C),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }


            }
            IconButton(onClick = { navController.navigate(Screens.SuaMonAn.screen) }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
            }
        }
    }
}