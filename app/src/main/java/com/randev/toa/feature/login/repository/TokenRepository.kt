package com.randev.toa.feature.login.repository

import com.randev.toa.feature.login.domain.model.Token

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

interface TokenRepository {
    suspend fun storeAuthToken(
        token: Token
    )
    suspend fun fetchAuthToken(): String?
}
