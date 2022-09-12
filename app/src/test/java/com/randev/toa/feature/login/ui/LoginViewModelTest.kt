package com.randev.toa.feature.login.ui

import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.Email
import com.randev.toa.feature.login.domain.model.Password
import org.junit.Before
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class LoginViewModelTest {
    private lateinit var testRobot: LoginViewModelRobot
    private val defaultCredentials = Credentials(
        Email("raihanarman@gmail.com"),
        Password("Hunter2")
    )

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
    fun testUpdateCredentials() {
        val credentials = defaultCredentials

        testRobot
            .buildViewModel()
            .enterEmail(credentials.email.value)
            .enterPassword(credentials.password.value)
        testRobot.assertViewState(LoginViewState.Active(credentials))
    }
}
