package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.feature.login.domain.model.LoginResult

/**
 * @author Raihan Arman
 * @date 10/09/22
 */
class SuccessLoginCredentialsUseCase : CredentialsLoginUseCase {
    override suspend fun invoke(email: Email, password: Password): LoginResult {
        return LoginResult.Success
    }
}
