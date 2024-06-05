package com.kot104.cum_tum_xthcntt.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R
import com.kot104.cum_tum_xthcntt.ROUTE_SCREEN_NAME
import com.kot104.cum_tum_xthcntt.ui.theme.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var anhien by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff373232))
    ){
        Column {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(Color(0xff252121))
                    .clip(RoundedCornerShape(30.dp))
            ){
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                ){
                    Text(
                        text = "Đăng nhập",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(20.dp),
                        color = Color.White,
                        fontSize = 40.sp)
                    Spacer(modifier = Modifier.height(60.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription ="",
                        Modifier
                            .fillMaxSize(0.6f)
                            .align(Alignment.CenterHorizontally))
                }

            }
            Box(
                Modifier.fillMaxWidth(0.8f).align(Alignment.CenterHorizontally),

            ){
                Column {
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White
                        ),
                        value = email,
                        onValueChange = {email = it},
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "Enter your email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp)
                    )
                    TextField(
                        visualTransformation = if (anhien) VisualTransformation.None else PasswordVisualTransformation(),
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                        value = pass,
                        onValueChange = {pass = it},
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Enter your password") },
                        trailingIcon = {
                            val image = if (anhien){
                                painterResource(id = R.drawable.ic_hien)
                            } else {
                                painterResource(id = R.drawable.ic_an)
                            }
                            IconButton(onClick = { anhien = !anhien }) {
                                Icon(painter = image, contentDescription = null)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( top = 25.dp)
                    )
                    TextButton(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 20.dp)) {
                        Text(text = "Forgot Password",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                        )
                    }
                    Button(
                        onClick = {navController.navigate(Screens.TrangChu.screen)},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF242424)
                        ),
                        shape = RoundedCornerShape(7.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(0.6f)
                            .padding(top = 30.dp)
                    ) {
                        Text(
                            text = "Log In",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(5.dp)
                        )

                    }
                    TextButton(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp)) {
                        Text(text = "Sign in".toUpperCase(),
                            fontSize = 20.sp,
                            color = Color(0xFFFFFFFF),
                        )
                    }
                }
        }



        }

    }
}