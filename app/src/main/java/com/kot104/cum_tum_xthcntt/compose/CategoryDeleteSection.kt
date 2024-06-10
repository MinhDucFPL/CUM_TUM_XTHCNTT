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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.Screen.admin.CarDialog
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@Composable
fun CategoryDeleteItem(
    category: LoaiMonAn,
    index: Int,
    navController: NavHostController,
    onDeleteCategory: (LoaiMonAn) -> Unit
) {
    // State để theo dõi trạng thái hiển thị của dialog
    val showDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff2F2D2D), shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${index}",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "${category.tenLoaiMon} ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                IconButton(onClick = {
                    // Khi nhấn vào icon xóa, mở dialog
                    showDialog.value = true
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
                }
            }
        }

        // Dialog xác nhận xóa
        if (showDialog.value) {
            CarDialog(
                title = "Xác nhận xóa",
                message = "Bạn có chắc chắn muốn xóa loại món này?",
                onConfirmClick = {
                    onDeleteCategory(category)
                    showDialog.value = false
                },
                onDismissClick = {
                    showDialog.value = false
                }
            )
        }
    }
}

