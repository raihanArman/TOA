package com.randev.toa.feature.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @author Raihan Arman
 * @date 14/09/22
 */

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    LoginContent(
        viewState = viewState.value,
        onUsernameChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::loginButtonClicked,
        onSignUpClicked = viewModel::signInButtonClicked
    )
}
