package com.randev.toa.fakes

import com.randev.toa.feature.login.domain.model.Token
import com.randev.toa.feature.login.repository.TokenRepository
import io.mockk.coVerify
import io.mockk.mockk

/**
 * @author Raihan Arman
 * @date 12/09/22
 */

class FakeTokenRepository {
    val mock: TokenRepository = mockk(
        relaxUnitFun = true
    )

    fun verifyTokenStored(token: Token) {
        coVerify {
            mock.storeAuthToken(token)
        }
    }

    fun verifyNoTokenStored() {
        coVerify(exactly = 0) {
            mock.storeAuthToken(any())
        }
    }
}
