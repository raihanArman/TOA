package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.core.data.Result
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.InvalidCredentialsException
import com.randev.toa.feature.login.domain.model.LoginResult
import com.randev.toa.feature.login.repository.LoginRepository
import com.randev.toa.feature.login.repository.TokenRepository

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class ProdCredentialsLoginUseCase(
    private val loginRepository: LoginRepository,
    private val authTokenRepository: TokenRepository
) : CredentialsLoginUseCase {
    override suspend fun invoke(credentials: Credentials): LoginResult {

        return when (val repoResult = loginRepository.loginWithCredentials(credentials)) {
            is Result.Success -> {
                authTokenRepository.storeAuthToken(repoResult.data.token)
                return LoginResult.Success
            }
            is Result.Error -> {
                loginResultForError(repoResult)
            }
        }
    }

    private fun loginResultForError(repoResult: Result.Error) =
        when (repoResult.error) {
            is InvalidCredentialsException -> {
                LoginResult.Failure.InvalidCredentials
            }
            else -> {
                LoginResult.Failure.Unknown
            }
        }
}