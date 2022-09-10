package com.randev.toa.feature.login.domain.model

/**
 * @author Raihan Arman
 * @date 10/09/22
 */

sealed class LoginResult {

    object Success : LoginResult()

    sealed class Failure : LoginResult() {
        object InvalidCredentials : Failure()
        object Unknown : Failure()
    }
}
