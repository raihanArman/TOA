package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResult

/**
 * @author Raihan Arman
 * @date 10/09/22
 */
interface CredentialsLoginUseCase {
    suspend operator fun invoke(
        credentials: Credentials
    ): LoginResult
}
