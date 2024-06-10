package com.kot104.cum_tum_xthcntt.Screen.admin

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.provider.DocumentsContract
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.kot104.cum_tum_xthcntt.Model.LoaiMonAn
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
import com.kot104.cum_tum_xthcntt.ViewModel.LoaiMonAnViewModel
import com.kot104.cum_tum_xthcntt.ViewModel.MonAnViewModel
import com.kot104.cum_tum_xthcntt.ui.theme.Screens
import java.io.File
import java.io.FileOutputStream
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDishesScreen(navController: NavHostController, viewModel: MonAnViewModel, loaiMonAnViewModel: LoaiMonAnViewModel) {
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    val gia = remember { mutableStateOf("") }
    val tenMon = remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val categoryLists by loaiMonAnViewModel.categories.observeAsState(emptyList())
    var selectedCategoryId by remember { mutableStateOf<String?>(null) }
    var selectedCategoryName by remember { mutableStateOf("") }
    val context = LocalContext.current

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
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
                .padding(top = 20.dp)
        ) {
            Row {
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
                ImageButton(
                    onClick = { launcher.launch("image/*") },
                    painter = selectedImageUri?.let { rememberAsyncImagePainter(it) } ?: painterResource(id = R.drawable.add_img),
                    contentDescription = "Select Image"
                )
                Spacer(modifier = Modifier.height(40.dp))
                DropDown(categoryLists, selectedCategoryName, { name, id ->
                    selectedCategoryName = name
                    selectedCategoryId = id
                })
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
                        val defaultImageUri = Uri.parse("android.resource://com.kot104.cum_tum_xthcntt/drawable/anh_mo_ta")
                        val imageUri = selectedImageUri ?: defaultImageUri

                        viewModel.themMonAn(tenMon.value, gia.value, selectedCategoryId ?: "", imageUri.toFile(context, Bitmap.CompressFormat.PNG)) { result ->
                            dialogMessage = if (result != null) "Thêm thành công" else "Tên món ăn đã tồn tại!"
                            showDialog = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.4f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffFFB703))
                ) {
                    Text(
                        text = "Thêm món ăn",
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
fun DropDown(
    categories: List<LoaiMonAn>,
    selectedCategoryName: String,
    onItemSelected: (String, String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFiledSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Loại Món Ăn",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.clickable { expanded = !expanded }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = if (selectedCategoryName.isNotEmpty()) selectedCategoryName else "Vui lòng chọn loại món ăn",
                onValueChange = { /* Read-only field */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFiledSize = coordinates.size.toSize()
                    },
                enabled = false,
                trailingIcon = {
                    Icon(icon, "", Modifier.clickable { expanded = !expanded })
                },
            )
            Icon(
                icon,
                "",
                tint = Color.White,
                modifier = Modifier.clickable { expanded = !expanded }
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFiledSize.width.toDp() })
        ) {
            categories.forEach { category ->
                DropdownMenuItem(
                    text = { Text(category.tenLoaiMon) },
                    onClick = {
                        onItemSelected(category.tenLoaiMon, category._id!!)
                        expanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = Color.Black,
                        leadingIconColor = Color.Black,
                        trailingIconColor = Color.Black
                    ),
                    modifier = Modifier.background(Color.White)
                )
            }
        }
    }
}

fun Uri.toFile(context: Context, format: Bitmap.CompressFormat): File {
    val inputStream = context.contentResolver.openInputStream(this)
    val fileName = "${System.currentTimeMillis()}${if (format == Bitmap.CompressFormat.PNG) ".png" else ".jpg"}"
    val outputDir = File(context.filesDir, "images")

    if (!outputDir.exists()) {
        outputDir.mkdirs()
    }

    val outputFile = File(outputDir, fileName)
    try {
        FileOutputStream(outputFile).use { output ->
            inputStream?.copyTo(output)
        }
        return outputFile
    } catch (e: Exception) {
        e.printStackTrace()
        throw RuntimeException("Failed to save image file", e)
    }
}