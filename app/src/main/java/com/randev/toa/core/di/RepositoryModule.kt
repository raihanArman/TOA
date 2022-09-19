package com.randev.toa.core.di

import com.randev.toa.feature.login.repository.DemoLoginService
import com.randev.toa.feature.login.repository.DemoTokenService
import com.randev.toa.feature.login.repository.LoginRepository
import com.randev.toa.feature.login.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Raihan Arman
 * @date 19/09/22
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTokenRepository(
        tokenRepository: DemoTokenService
    ): TokenRepository

    @Binds
    abstract fun bindLoginRepository(
        loginRepository: DemoLoginService
    ): LoginRepository
}
