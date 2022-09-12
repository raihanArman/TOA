package com.randev.toa.feature.login.domain.model

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(val value: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(val value: String)

data class Credentials(
    val email: Email,
    val password: Password
)
