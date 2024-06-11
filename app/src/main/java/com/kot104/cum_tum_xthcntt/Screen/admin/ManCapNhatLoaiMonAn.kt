package com.kot104.cum_tum_xthcntt.Screen.admin

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.ViewModel.LoaiMonAnViewModel
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateCategoryScreen(navController: NavHostController, viewModel: LoaiMonAnViewModel, category: LoaiMonAn) {
    var categoryName by remember { mutableStateOf(category.tenLoaiMon) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var trangThai by remember {
        mutableStateOf(1)
    }

    if (trangThai == 1) {
        if (showDialog) {
            DialogComponent(
                onConfirmation = { showDialog = false },
                dialogTitle = "Thông báo",
                dialogMessage = dialogMessage
            )
        }
    } else {
        if (showDialog) {
            DialogComponent(
                onConfirmation = { showDialog = false },
                dialogTitle = "Thông báo",
                dialogMessage = dialogMessage
            )
        }
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
                IconButton(onClick = { navController.navigate(Screens.QuanLyLoaiMonAn.screen) }) {
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
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White
                    ),
                    value = categoryName,
                    onValueChange = { categoryName = it },
                    label = { Text(text = "Nhập tên loại món ăn") },
                    placeholder = { Text(text = "Nhập tên loại món ăn") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                    shape = RoundedCornerShape(20.dp)
                )
                Button(
                    onClick = {
                        val newName = categoryName.trim()
                        if (newName.isNotEmpty()) {
                            val existingCategory = viewModel.categories.value?.find { it.tenLoaiMon.equals(newName, ignoreCase = true) }
                            if (existingCategory == null || existingCategory._id == category._id) {
                                val updatedCategory = category.copy(tenLoaiMon = newName)
                                viewModel.suaLoaiMon(category._id!!, updatedCategory)
                                trangThai = 1
                                dialogMessage = "Cập nhật tên loại món thành công."
                            } else {
                                trangThai = 2
                                dialogMessage = "Tên loại món đã tồn tại."
                            }
                            showDialog = true
                        } else {
                            trangThai = 3
                            dialogMessage = "Vui lòng nhập tên loại món."
                            showDialog = true
                        }
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