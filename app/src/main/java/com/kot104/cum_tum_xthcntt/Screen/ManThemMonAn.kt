package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//navController: NavHostController
fun AddDishesScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    val gia = remember { mutableStateOf("") }
    val tenMon = remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

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
                .padding(top = 20.dp)
        ) {
            Row {
                //navController.navigate("manageCategories")
                IconButton(onClick = {  navController.navigate(Screens.QuanLyMonAn.screen) }) {
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
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .padding(start  = 40.dp)
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageButton(onClick = { /*TODO*/ },
                    painter = painterResource(id = R.drawable.add_img), contentDescription = "")
                Spacer(modifier = Modifier.height(40.dp))
                DropDown()
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Giá",
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
                Text(text = "Tên món",
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp),
                    color = Color.White,
                    fontSize = 18.sp)
                TextField(
                    value = tenMon.value,
                    onValueChange = { tenMon.value = it },
                    Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        dialogMessage = "Thêm thành công"
                        showDialog=true
//                        navController.navigate("ManageDishes")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.4f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffFFB703))
                ) {
                    Text(
                        text = "Thêm",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.2.em
                    )
                }

            }
        }
    }
}

@Composable
fun ImageButton(onClick: () -> Unit, painter: Painter, contentDescription: String?) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(205.dp)
            .clickable(onClick = onClick)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown() {
    val list = listOf("Món chính", "Món phụ", "Topping", "Khác")
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFiledSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    val backgroundColor = Color.White
    val contentColor = Color.Black

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Loại Món Ăn", fontSize = 18.sp , color = Color.White)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFiledSize.width.toDp() })
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    text = { Text(label) },
                    onClick = {
                        selectedItem = label
                        expanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = contentColor,
                        leadingIconColor = contentColor,
                        trailingIconColor = contentColor
                    ),
                    modifier = Modifier.background(backgroundColor)
                )
            }
        }
    }
}
