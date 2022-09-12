package com.randev.toa.fakes

import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.usecase.CredentialsLoginUseCase
import io.mockk.coEvery
import io.mockk.mockk

/**
 * @author Raihan Arman
 * @date 12/09/22
 */
class FakeCredentialsLoginUseCase {
    val mock: CredentialsLoginUseCase = mockk()

    fun mockLoginResult(
        credentials: Credentials,
        result: LoginResult
    ) {
        coEvery {
            mock(credentials)
        } returns result
    }
}
