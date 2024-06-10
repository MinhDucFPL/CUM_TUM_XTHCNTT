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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.ViewModel.LoaiMonAnViewModel
import com.kot104.cum_tum_xthcntt.compose.CategoryDeleteItem
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@Composable
//navController: NavHostController
fun DeleteCategoryScreen(navController: NavHostController, loaiMonAnViewModel: LoaiMonAnViewModel) {
    val categoryLists by loaiMonAnViewModel.categories.observeAsState(emptyList())
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                LazyColumn {
                    itemsIndexed(categoryLists) { index, category ->
                        CategoryDeleteItem(category, index + 1, navController,
                            onDeleteCategory = { deletedCategory ->
                                loaiMonAnViewModel.xoaLoaiMon(category._id!!)
                            })
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
        }
    }
}

@Composable
fun CarDialog(
    title: String,
    message: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = onConfirmClick,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(
                            text = "Xác nhận",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Button(
                        onClick = {
                            openDialog.value = false
                            onDismissClick()
                        },
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(Color(0xFFB703))
                    ) {
                        Text(
                            text = "Hủy",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}


