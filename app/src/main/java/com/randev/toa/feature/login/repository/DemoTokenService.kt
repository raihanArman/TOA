package com.randev.toa.feature.login.repository

import com.randev.toa.feature.login.domain.model.Token

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

class DemoTokenService : TokenRepository {
    override suspend fun storeAuthToken(token: Token) {
        // No
    }

    override suspend fun fetchAuthToken(): String? {
        return null
    }
}
