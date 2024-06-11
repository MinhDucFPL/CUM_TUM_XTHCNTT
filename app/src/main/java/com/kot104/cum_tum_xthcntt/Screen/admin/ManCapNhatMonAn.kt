package com.kot104.cum_tum_xthcntt.Screen.admin

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.kot104.cum_tum_xthcntt.Model.MonAn
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ViewModel.LoaiMonAnViewModel
import com.kot104.cum_tum_xthcntt.ViewModel.MonAnViewModel
import com.kot104.cum_tum_xthcntt.ui.theme.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateDishesScreen(navController: NavHostController, loaiMonAnViewModel: LoaiMonAnViewModel, monAnViewModel: MonAnViewModel, dish : MonAn) {
    var chonAnh = remember {
        mutableStateOf(false)
    }
    val gia = remember { mutableStateOf("" + dish.giaMon) }
    val tenMon = remember { mutableStateOf(dish.tenMon) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    var selectedImageUri by remember { mutableStateOf<Uri?>(Uri.parse(dish.hinhAnh)) }
    var luuUriAnh by remember { mutableStateOf<Uri?>(Uri.parse(dish.hinhAnh)) }

    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri == null) {
            selectedImageUri = luuUriAnh
        } else {
            chonAnh.value = true
            selectedImageUri = uri
        }
    }

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
                IconButton(onClick = { navController.navigate(Screens.QuanLyMonAn.screen) }) {
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    ImageButton(
                        onClick = { launcher.launch("image/*") },
                        painter = selectedImageUri?.let { rememberAsyncImagePainter(it) } ?: painterResource(R.drawable.anh_mo_ta),
                        contentDescription = "Select Image"
                    )
                    Spacer(modifier = Modifier.height(25.dp))
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
                            Log.e("ThuocTinhMonAn", "Lỗi khi sửa món ăn: dish._id: ${dish._id}, tenMon: ${tenMon.value}, gia: ${gia.value}, id_loaiMonAn: ${dish.id_loaiMonAn}")
                            monAnViewModel.suaMonAn(dish._id, tenMon.value, gia.value, dish.id_loaiMonAn, selectedImageUri!!.toFile(context, Bitmap.CompressFormat.PNG)) { result ->
                                dialogMessage = if (result != null) "Cập nhật thông tin thành công" else "Tên món ăn đã tồn tại!"
                                showDialog = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.4f),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffFFB703))
                    ) {
                        Text(
                            text = "Lưu",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.2.em
                        )
                    }
            }
        }
    }
}