package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.core.data.Result
import com.randev.toa.fakes.FakeLoginRepository
import com.randev.toa.fakes.FakeTokenRepository
import com.randev.toa.feature.login.domain.model.AuthToken
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.Email
import com.randev.toa.feature.login.domain.model.InvalidCredentialsException
import com.randev.toa.feature.login.domain.model.LoginResponse
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.model.Password
import com.randev.toa.feature.login.domain.model.RefreshToken
import com.randev.toa.feature.login.domain.model.Token
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class ProdCredentialsLoginUseCaseTest {

    private val defaultCrendentials = Credentials(
        email = Email("raihan@gmail.com"),
        password = Password("12345678")
    )

    private val defaultToken = Token(
        authToken = AuthToken("Auth"),
        refreshToken = RefreshToken("Refresh")
    )

    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var tokenRepository: FakeTokenRepository

    @Before
    fun setUp() {
        loginRepository = FakeLoginRepository()
        tokenRepository = FakeTokenRepository()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSuccessfulLogin() = runBlockingTest {
        val response = Result.Success(
            LoginResponse(
                token = defaultToken
            )
        )

        loginRepository.mockLoginWithCredentials(
            defaultCrendentials,
            response
        )

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock, tokenRepository.mock)
        val actualResult = useCase(defaultCrendentials)

        assert(actualResult is LoginResult.Success)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testUnknownFailureLogin() = runBlockingTest {

        val mockResult = Result.Error(
            Throwable("Error")
        )

        loginRepository.mockLoginWithCredentials(
            defaultCrendentials,
            mockResult
        )

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock, tokenRepository.mock)
        val actualResult = useCase(defaultCrendentials)

        assert(actualResult is LoginResult.Failure.Unknown)
        tokenRepository.verifyNoTokenStored()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testInvalidCredentialsLogin() = runBlockingTest {
        val mockResult = Result.Error(
            InvalidCredentialsException()
        )

        loginRepository.mockLoginWithCredentials(
            defaultCrendentials,
            mockResult
        )

        val useCase = ProdCredentialsLoginUseCase(loginRepository.mock, tokenRepository.mock)
        val actualResult = useCase(defaultCrendentials)

        assert(actualResult is LoginResult.Failure.InvalidCredentials)
        tokenRepository.verifyNoTokenStored()
    }

//    @Test
//    fun testEmptyCredentialsLogin() = runBlockingTest {
//        val emptyCredentials = Credentials()
//
//        val useCase = ProdCredentialsLoginUseCase(
//            loginRepository = loginRepository.mock,
//            authTokenRepository = tokenRepository.mock
//        )
//
//        val result = useCase(emptyCredentials)
//        Assert.assertEquals(result, LoginResult.Failure.EmptyCredentials(true, true))
//
//        loginRepository.verifyNoLoginCall()
//        tokenRepository.verifyNoTokenStored()
//    }
}
