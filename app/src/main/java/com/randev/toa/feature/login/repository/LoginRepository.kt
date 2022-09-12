package com.randev.toa.feature.login.repository

import com.randev.toa.core.data.Result
import com.randev.toa.feature.login.domain.model.Credentials
import com.randev.toa.feature.login.domain.model.LoginResponse

/**
 * @author Raihan Arman
 * @date 12/09/22
 */
interface LoginRepository {
    suspend fun loginWithCredentials(
        credentials: Credentials
    ): Result<LoginResponse>
}
