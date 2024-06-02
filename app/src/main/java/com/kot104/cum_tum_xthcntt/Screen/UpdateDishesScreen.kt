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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//navController: NavHostController
fun UpdateDishesScreen(navController: NavHostController) {
    val gia = remember { mutableStateOf("") }
    val tenMon = remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    if (showDialog) {
        DialogComponent(
            onConfirmation = { showDialog = false },
            dialogTitle = "Thông báo",
            dialogMessage = dialogMessage
        )
    }

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
            Row {

                IconButton(onClick = { navController.navigate(ROUTE_SCREEN_NAME.MANAGEDISHES.name)}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "",
                        tint = Color.Black,
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth(0.9f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageButton(
                        onClick = { /*TODO*/ },
                        painter = painterResource(id = R.drawable.img_food), contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    DropDown()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Giá",
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    TextField(
                        value = gia.value,
                        onValueChange = { gia.value = it },
                        Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tên món",
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    TextField(
                        value = tenMon.value,
                        onValueChange = { tenMon.value = it },
                        Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {
                            dialogMessage = "Cập nhật thành công"
                            showDialog = true
                            navController.navigate(ROUTE_SCREEN_NAME.MANAGEDISHES.name)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.4f),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffFFB703))
                    ) {
                        Text(
                            text = "Update",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.2.em
                        )
                    }
                }
            }
        }
    }
}