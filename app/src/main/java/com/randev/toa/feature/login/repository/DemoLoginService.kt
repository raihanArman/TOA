package com.randev.toa.feature.login.repository

import com.randev.toa.core.data.Result
import com.randev.toa.feature.login.domain.model.AuthToken
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResponse
import com.randev.toa.feature.login.domain.model.RefreshToken
import com.randev.toa.feature.login.domain.model.Token
import javax.inject.Inject

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

class DemoLoginService @Inject constructor() : LoginRepository {
    override suspend fun loginWithCredentials(credentials: Credentials): Result<LoginResponse> {
        val defaultToken = Token(
            AuthToken(""),
            RefreshToken("")
        )

        val defaultResponse = LoginResponse(defaultToken)

        return Result.Success(defaultResponse)
    }
}
