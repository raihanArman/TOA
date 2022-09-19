package com.randev.toa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.randev.toa.feature.login.ui.LoginScreen
import com.randev.toa.ui.theme.TOATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TOATheme {
                LoginScreen()
            }
        }
    }
}
