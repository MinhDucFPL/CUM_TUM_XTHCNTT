package com.kot104.cum_tum_xthcntt.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.Model.Category

val categoryLists= listOf(
    Category(1, "Sườn"),
    Category(2, "Sườn Bì"),
    Category(3, "Bì Chả")
)

@Composable
fun CategorySection(navController: NavHostController){
    LazyColumn {
        items(categoryLists.size) { index ->
            CategoryItem(index,navController)
            if (index < categoryLists.size - 1) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
@Composable
fun CategoryItem(index: Int,navController: NavHostController){
    val cat = categoryLists[index]
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
                    .background(Color(0xff2F2D2D), shape = RoundedCornerShape(10.dp)).padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                    Text(
                        text = "${cat.id}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "${cat.name} ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    IconButton(onClick = { navController.navigate("UpdateCategory") }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
                    }
            }

        }
    }
}