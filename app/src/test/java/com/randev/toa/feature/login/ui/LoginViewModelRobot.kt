package com.randev.toa.feature.login.ui

import app.cash.turbine.test
import com.randev.toa.fakes.FakeCredentialsLoginUseCase
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResult
import org.junit.Assert.assertEquals

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class LoginViewModelRobot {
    private val fakeCredentialsLoginUseCase = FakeCredentialsLoginUseCase()
    private lateinit var viewModel: LoginViewModel

    fun buildViewModel() = apply {
        viewModel = LoginViewModel(
            credentialsLoginUseCase = fakeCredentialsLoginUseCase.mock
        )
    }

    fun mockLoginResultForCredentials(
        credentials: Credentials,
        result: LoginResult
    ) = apply {
        fakeCredentialsLoginUseCase.mockLoginResult(credentials, result)
    }

    fun enterEmail(email: String) = apply {
        viewModel.emailChanged(email)
    }

    fun enterPassword(password: String) {
        viewModel.passwordChanged(password)
    }

    fun clickLogInButton() = apply {
        viewModel.loginButtonClicked()
    }

    fun clickSignUpButton() = apply {
        viewModel.signInButtonClicked()
    }

    fun assertViewState(expectedViewState: LoginViewState) = apply {
        assert(viewModel.viewState.value == expectedViewState)
    }

    suspend fun assertViewStatesAfterAction(
        viewStates: List<LoginViewState>,
        action: LoginViewModelRobot.() -> Unit,
    ) = apply {
        viewModel.viewState.test {
            action()

            for (state in viewStates) {
                assertEquals(state, awaitItem())
            }

//            cancel()
        }
    }
}
