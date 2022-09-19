package com.randev.toa

import android.os.Bundle
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
                Greeting("Raihan")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Helo $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TOATheme {
        Greeting("Android")
    }
}
