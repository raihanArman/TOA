package com.randev.toa.feature.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.randev.toa.R
import com.randev.toa.feature.UIText
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.Email
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.model.Password
import com.randev.toa.feature.login.domain.usecase.CredentialsLoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class LoginViewModel(
    private val credentialsLoginUseCase: CredentialsLoginUseCase
) : ViewModel() {
    private val _viewState: MutableStateFlow<LoginViewState> =
        MutableStateFlow(LoginViewState.Initial)
    val viewState: StateFlow<LoginViewState> = _viewState

    fun emailChanged(email: String) {
        val currentCredentials = _viewState.value.credentials
        val currentPasswordErrorMessage = (_viewState.value as? LoginViewState.Active)?.passwordInputErrorMessage

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedEmail(email = email),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = currentPasswordErrorMessage
        )
    }

    fun passwordChanged(password: String) {
        val currentCredentials = _viewState.value.credentials
        val currentEmailErrorMessage = (_viewState.value as? LoginViewState.Active)?.emailInputErrorMessage

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedPassword(password = password),
            emailInputErrorMessage = currentEmailErrorMessage,
            passwordInputErrorMessage = null
        )
    }

    fun signInButtonClicked() {
        //  click signUp
    }

    fun loginButtonClicked() {
        val currentCredentials = _viewState.value.credentials

        _viewState.value = LoginViewState.Submitting(
            credentials = currentCredentials
        )

        viewModelScope.launch {
            val loginResult = credentialsLoginUseCase(currentCredentials)

            _viewState.value = when (loginResult) {
                is LoginResult.Failure.InvalidCredentials -> {
                    LoginViewState.SubmissionError(
                        credentials = currentCredentials,
                        errorMessage = UIText.ResourceText(R.string.err_invalid_credentials)
                    )
                }
                is LoginResult.Failure.Unknown -> {
                    LoginViewState.SubmissionError(
                        credentials = currentCredentials,
                        errorMessage = UIText.ResourceText(R.string.err_login_failure)
                    )
                }
                is LoginResult.Failure.EmptyCredentials -> {
                    loginResult.toLoginViewState(credentials = currentCredentials)
                }
                else -> _viewState.value
            }
        }
    }

    private fun Credentials.withUpdatedEmail(email: String): Credentials {
        return this.copy(email = Email(email))
    }

    private fun Credentials.withUpdatedPassword(password: String): Credentials {
        return this.copy(password = Password(password))
    }

    private fun LoginResult.Failure.EmptyCredentials.toLoginViewState(credentials: Credentials): LoginViewState {
        return LoginViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = UIText.ResourceText(R.string.err_empty_email).takeIf {
                this.emptyEmail
            },
            passwordInputErrorMessage = this.emptyPassword.takeIf { it }?.let {
                UIText.ResourceText(R.string.err_empty_password)
            }
        )
    }
}
