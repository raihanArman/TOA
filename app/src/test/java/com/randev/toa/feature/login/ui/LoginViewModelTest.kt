package com.randev.toa.feature.login.ui

import com.randev.toa.CoroutinesTestRule
import com.randev.toa.R
import com.randev.toa.ThreadExceptionHandlerTestRule
import com.randev.toa.feature.UIText
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.Email
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.model.Password
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class LoginViewModelTest {
    private lateinit var testRobot: LoginViewModelRobot

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val threadExceptionHandlerTestRule = ThreadExceptionHandlerTestRule()

    @Before
    fun setUp() {
        testRobot = LoginViewModelRobot()
    }

    @Test
    fun testInitialState() {
        testRobot
            .buildViewModel()
            .assertViewState(LoginViewState.Initial)
    }

    @Test
    fun testUpdateCredentials() = runBlockingTest {
        val testEmail = "raihan@gmail.com"
        val testPassword = "12345678"

        val initialState = LoginViewState.Initial
        val emailEnteredState = LoginViewState.Active(
            credentials = Credentials(email = Email(testEmail),)
        )
        val emailPasswordEnteredState = LoginViewState.Active(
            credentials = Credentials(email = Email(testEmail), password = Password(testPassword))
        )
        val expectedViewStates = listOf(
            initialState,
            emailEnteredState,
            emailPasswordEnteredState
        )

        testRobot
            .buildViewModel()
            .expectViewStates(
                viewStates = expectedViewStates
            )
            .enterEmail(testEmail)
            .enterPassword(testPassword)
    }

    @Test
    fun testSubmitInvalidCredentials() = runBlockingTest {
        val testEmail = "raihan@gmail.com"
        val testPassword = "12345678"
        val completeCredentials = Credentials(
            email = Email(testEmail),
            password = Password(testPassword)
        )

        val initialState = LoginViewState.Initial
        val emailEnteredState = LoginViewState.Active(
            credentials = Credentials(email = Email(testEmail))
        )
        val emailPasswordEnteredState = LoginViewState.Active(
            credentials = completeCredentials
        )

        val submittingState = LoginViewState.Submitting(
            credentials = completeCredentials
        )

        val submittingErrorState = LoginViewState.SubmissionError(
            credentials = completeCredentials,
            errorMessage = UIText.ResourceText(R.string.err_invalid_credentials)
        )

        val expectedViewStates = listOf(
            initialState,
            emailEnteredState,
            emailPasswordEnteredState,
            submittingState,
            submittingErrorState
        )

        testRobot
            .buildViewModel()
            .mockLoginResultForCredentials(
                credentials = completeCredentials,
                result = LoginResult.Failure.InvalidCredentials
            )
            .assertViewStatesAfterAction(
                viewStates = expectedViewStates
            ) {
                enterEmail(testEmail)
                enterPassword(testPassword)
                clickLogInButton()
            }
    }

    @Test
    fun testUnknownLoginFeature() = runBlockingTest {
        val testEmail = "raihan@gmail.com"
        val testPassword = "12345678"
        val completeCredentials = Credentials(
            email = Email(testEmail),
            password = Password(testPassword)
        )

        val initialState = LoginViewState.Initial
        val emailEnteredState = LoginViewState.Active(
            credentials = Credentials(email = Email(testEmail))
        )
        val emailPasswordEnteredState = LoginViewState.Active(
            credentials = completeCredentials
        )

        val submittingState = LoginViewState.Submitting(
            credentials = completeCredentials
        )

        val submittingErrorState = LoginViewState.SubmissionError(
            credentials = completeCredentials,
            errorMessage = UIText.ResourceText(R.string.err_login_failure)
        )

        val expectedViewStates = listOf(
            initialState,
            emailEnteredState,
            emailPasswordEnteredState,
            submittingState,
            submittingErrorState
        )

        testRobot
            .buildViewModel()
            .mockLoginResultForCredentials(
                credentials = completeCredentials,
                result = LoginResult.Failure.Unknown
            )
            .expectViewStates(
                viewStates = expectedViewStates
            )
            .enterEmail(testEmail)
            .enterPassword(testPassword)
        testRobot.clickLogInButton()
    }

    @Test
    fun testSubmitWithoutCredential() = runBlockingTest {
        val credentials = Credentials()

        val initialState = LoginViewState.Initial
        val invalidInputState = LoginViewState.Active(
            credentials = Credentials(),
            emailInputErrorMessage = UIText.ResourceText(R.string.err_empty_email),
            passwordInputErrorMessage = UIText.ResourceText(R.string.err_empty_password)
        )

        testRobot
            .buildViewModel()
            .expectViewStates(
                viewStates = listOf(
                    initialState,
                    invalidInputState
                )
            )
            .mockLoginResultForCredentials(
                credentials = credentials,
                result = LoginResult.Failure.EmptyCredentials(
                    true,
                    true
                )
            )
        testRobot.clickLogInButton()
    }
}
