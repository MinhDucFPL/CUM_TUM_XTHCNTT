package com.kot104.cum_tum_xthcntt.Screen.admin

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.compose.StatisticalSection
import java.time.LocalDate
import java.time.format.DateTimeFormatter
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
//@Preview
@Composable
//navController: NavHostController
fun StatisticalScreen(navController: NavHostController) {
    val selectedButton = remember { mutableStateOf("Doanh thu") }
    val fromDateText = remember { mutableStateOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff252121))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar()
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(Color.Black))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp), // Add padding from top
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Add Doanh thu button
            Button(
                onClick = { selectedButton.value = "Doanh thu" },
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .padding(end = 1.dp)
                    .background(Color(0xff2F2D2D)), // Add background color to button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2F2D2D),
                )
            ) {
                Text(
                    text = "Doanh thu",
                    color = if (selectedButton.value == "Doanh thu") Color(0xffFFD700) else Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            // Add Biểu đồ button
            Button(
                onClick = { selectedButton.value = "Biểu đồ" },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 1.dp)
                    .height(45.dp)
                    .background(Color(0xff2F2D2D)), // Add background color to button
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2F2D2D),
                )
            ) {
                Text(
                    text = "Biểu đồ",
                    color = if (selectedButton.value == "Biểu đồ") Color(0xffFFD700) else Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
            Row (modifier = Modifier
                .padding(top = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(110.dp)
                        .background(Color(0xff2F2D2D))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Từ ngày",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                TextField(
                    value = fromDateText.value,
                    onValueChange = { fromDateText.value = it },
                    modifier = Modifier
                        .height(50.dp)
                        .width(110.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xff2F2D2D),
                    ),
                    textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
                    singleLine = true
                )
            }
            Row (modifier = Modifier
                .padding(top = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(110.dp)
                        .background(Color(0xff2F2D2D))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Từ ngày",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                TextField(
                    value = fromDateText.value,
                    onValueChange = { fromDateText.value = it },
                    modifier = Modifier
                        .height(50.dp)
                        .width(110.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xff2F2D2D),
                    ),
                    textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth())
            Spacer(modifier = Modifier
                .height(4.dp)
                .fillMaxWidth()
                .background(Color.Black))
            StatisticalSection()
        }

    }
}
@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.width(60.dp)
        )

        Text(
            text = "Cum tứm đim",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        )
    }
}
