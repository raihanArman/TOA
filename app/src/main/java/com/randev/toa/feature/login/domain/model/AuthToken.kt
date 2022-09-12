package com.randev.toa.feature.login.domain.model

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

@JvmInline
value class AuthToken(val value: String)

@JvmInline
value class RefreshToken(val value: String)

data class Token(
    val authToken: AuthToken,
    val refreshToken: RefreshToken
)
