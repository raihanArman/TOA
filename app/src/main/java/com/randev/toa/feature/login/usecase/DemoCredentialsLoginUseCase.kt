package com.randev.toa.feature.login.usecase

import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.domain.usecase.CredentialsLoginUseCase

/**
 * @author Raihan Arman
 * @date 14/09/22
 */
class DemoCredentialsLoginUseCase : CredentialsLoginUseCase {
    override suspend fun invoke(credentials: Credentials): LoginResult {
        return LoginResult.Failure.InvalidCredentials
    }
}
