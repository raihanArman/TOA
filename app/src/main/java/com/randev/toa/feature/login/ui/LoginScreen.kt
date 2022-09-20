package com.randev.toa.feature.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun LoginScreen(
    onLoginCompleted: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        coroutineScope.launch {
            viewModel.loginCompletedChannel.receive()
            onLoginCompleted.invoke()
        }
    }

    LoginContent(
        viewState = viewState.value,
        onUsernameChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::loginButtonClicked,
        onSignUpClicked = viewModel::signInButtonClicked
    )
}
