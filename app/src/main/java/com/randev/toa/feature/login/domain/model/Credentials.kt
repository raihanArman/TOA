package com.randev.toa.feature.login.domain.model

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(private val email: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(private val password: String)

data class Credentials(
    val email: Email,
    val password: Password
)
