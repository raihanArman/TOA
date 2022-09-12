package com.randev.toa.feature.login.ui

import com.randev.toa.feature.login.domain.model.Credentials

/**
 * @author Raihan Arman
 * @date 04/09/22
 */

// data class LoginViewState(
//    val email: String,
//    val password: String,
//    val showProgressBar: Boolean,
//    val errorMessage: String?,
//    val emailInputErrorMessage: String?,
//    val passwordInputErrorMessage: String?
// )

sealed class LoginViewState(
    open val credentials: Credentials,
    open val buttonEnabled: Boolean = true,
) {
    object Initial : LoginViewState(
        credentials = Credentials()
    )

    data class Active(
        override val credentials: Credentials
    ) : LoginViewState(
        credentials = credentials
    )

    data class Submitting(
        override val credentials: Credentials
    ) : LoginViewState(
        credentials = credentials,
        buttonEnabled = false
    )

    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: String
    ) : LoginViewState(
        credentials = credentials
    )

    data class InputError(
        override val credentials: Credentials,
        val emailInputErrorMessage: String?,
        val passwordInputErrorMessage: String?
    ) : LoginViewState(
        credentials = credentials
    )
}
