package com.randev.toa.feature.login.domain.usecase

import com.randev.toa.feature.login.domain.model.LoginResult

/**
 * @author Raihan Arman
 * @date 10/09/22
 */

@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(private val email: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(private val password: String)

interface CredentialsLoginUseCase {
    suspend operator fun invoke(
        email: Email,
        password: Password
    ): LoginResult
}
