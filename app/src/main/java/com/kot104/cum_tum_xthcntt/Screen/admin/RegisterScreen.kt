package com.kot104.cum_tum_xthcntt.Screen.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kot104.cum_tum_xthcntt.R

//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//navControl: NavHostController
fun Register(navControl: NavHostController){
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var passConfirm by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var anhien by remember { mutableStateOf(false) }
    var anhienconfirm by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xff373232)
        )){

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .height(150.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillHeight
            )
            Text(text = "welcome".toUpperCase(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color(0xFFFFFFFF),
                modifier = Modifier.fillMaxWidth().padding(start = 50.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xff252121)),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            ){
                Column {
                    TextField(
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White
                        ),
                        value = name,
                        onValueChange = {name = it},
                        label = { Text(text = "Name") },
                        placeholder = { Text(text = "Enter your name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 10.dp, top = 25.dp)
                    )
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
                            .padding(start = 30.dp, end = 10.dp, top = 25.dp)
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
                            .padding(start = 30.dp, end = 10.dp, top = 25.dp)
                    )
                    TextField(
                        visualTransformation = if (anhienconfirm) VisualTransformation.None else PasswordVisualTransformation(),
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                        value = passConfirm,
                        onValueChange = {passConfirm = it},
                        label = { Text(text = "Confirm Password") },
                        placeholder = { Text(text = "Enter your confirm password") },
                        trailingIcon = {
                            val image = if (anhienconfirm){
                                painterResource(id = R.drawable.ic_hien)
                            } else {
                                painterResource(id = R.drawable.ic_an)
                            }
                            IconButton(onClick = { anhienconfirm = !anhienconfirm }) {
                                Icon(painter = image, contentDescription = null)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 10.dp, top = 25.dp)
                    )
                    Button(
                        //navControl.navigate("Login")
                        onClick = {navControl.navigate("DangNhap")},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFC47B54)
                        ),
                        shape = RoundedCornerShape(7.dp),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(0.8f)
                            .padding(top = 50.dp)
                    ) {
                        Text(
                            text = "Sign up".toUpperCase(),
                            fontSize = 20.sp,
                            modifier = Modifier.padding(5.dp)
                        )

                    }
                    TextButton(
                        //navControl.navigate("Login")
                        onClick = {navControl.navigate("DangNhap")},
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)) {
                        Text(text = "Already have account? ",
                            color = Color(0xFF8A736A)
                        )
                        Text(text = "Sign in".toUpperCase(),
                            color = Color(0xFFF06630),
                        )
                    }

                }
            }
        }
    }
}