package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.core.data.Result
import com.randev.toa.fakes.FakeLoginRepository
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.Email
import com.randev.toa.feature.login.domain.model.InvalidCredentialsException
import com.randev.toa.feature.login.domain.model.LoginResponse
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.model.Password
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class ProdCredentialsLoginUseCaseTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSuccessfulLogin() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("raihan@gmail.com"),
            password = Password("12345678")
        )
        val response = LoginResponse(
            authToken = "Success"
        )
        val mockResult = Result.Success(response)

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockResult
            )
        }

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock)
        val actualResult = useCase(inputCredentials)

        assert(actualResult is LoginResult.Success)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testUnknownFailureLogin() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("raihan@gmail.com"),
            password = Password("12345678")
        )
        val response = LoginResponse(
            authToken = "Success"
        )
        val mockResult = Result.Error(
            Throwable("Error")
        )

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockResult
            )
        }

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock)
        val actualResult = useCase(inputCredentials)

        assert(actualResult is LoginResult.Failure.Unknown)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testInvalidCredentialsLogin() = runBlockingTest {
        val inputCredentials = Credentials(
            email = Email("raihan@gmail.com"),
            password = Password("12345678")
        )
        val response = LoginResponse(
            authToken = "Success"
        )
        val mockResult = Result.Error(
            InvalidCredentialsException()
        )

        val loginRepository = FakeLoginRepository().apply {
            mockLoginWithCredentials(
                inputCredentials,
                mockResult
            )
        }

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock)
        val actualResult = useCase(inputCredentials)

        assert(actualResult is LoginResult.Failure.InvalidCredentials)
    }
}
