package com.randev.toa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.randev.toa.feature.login.ui.LoginScreen
import com.randev.toa.feature.login.ui.LoginViewModel
import com.randev.toa.feature.login.usecase.DemoCredentialsLoginUseCase
import com.randev.toa.ui.theme.TOATheme

class MainActivity : ComponentActivity() {
    private lateinit var loginViewModel: LoginViewModel

    private val loginViewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val usecase = DemoCredentialsLoginUseCase()
            return LoginViewModel(usecase) as T
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setContent {
            TOATheme {
                LoginScreen(viewModel = loginViewModel)
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
