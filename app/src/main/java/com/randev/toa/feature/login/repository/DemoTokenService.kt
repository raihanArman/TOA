package com.randev.toa.feature.login.repository

import com.randev.toa.feature.login.domain.model.Token
import javax.inject.Inject

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

class DemoTokenService @Inject constructor() : TokenRepository {
    override suspend fun storeAuthToken(token: Token) {
        // No
    }

    override suspend fun fetchAuthToken(): String? {
        return null
    }
}
