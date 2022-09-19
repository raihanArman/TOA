package com.randev.toa.feature.login.usecase

import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.usecase.CredentialsLoginUseCase
import kotlinx.coroutines.delay

/**
 * @author Raihan Arman
 * @date 14/09/22
 */
class DemoCredentialsLoginUseCase : CredentialsLoginUseCase {

    @Suppress("MagicNumber")
    override suspend fun invoke(credentials: Credentials): LoginResult {
        delay(2000)
        return LoginResult.Failure.InvalidCredentials
    }
}
