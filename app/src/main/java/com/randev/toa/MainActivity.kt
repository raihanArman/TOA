package com.randev.toa

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randev.toa.ui.theme.TOATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TOATheme {
                LoginScreen(
                    onLoginCompleted = {
                        Log.d("MainActivity", "onCreate: Login has been completed")
                    }
                )
            }
        }
    }
}
