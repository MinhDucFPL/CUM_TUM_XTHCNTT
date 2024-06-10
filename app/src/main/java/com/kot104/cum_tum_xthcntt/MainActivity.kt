package com.kot104.cum_tum_xthcntt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kot104.cum_tum_xthcntt.ViewModel.LoaiMonAnViewModel
import com.kot104.cum_tum_xthcntt.ViewModel.MonAnViewModel
import com.kot104.cum_tum_xthcntt.ui.theme.CUM_TUM_XTHCNTTTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CUM_TUM_XTHCNTTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val monAnViewModel = MonAnViewModel()
                    val loaiMonAnViewModel = LoaiMonAnViewModel()
                    AppNavHost(
                        navController = navController,
                        monAnViewModel = monAnViewModel,
                        loaiMonAnViewModel = loaiMonAnViewModel
                    )
                }
            }
        }
    }
}