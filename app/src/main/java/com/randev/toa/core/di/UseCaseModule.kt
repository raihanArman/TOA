package com.randev.toa.core.di

import com.randev.toa.feature.login.domain.usecase.CredentialsLoginUseCase
import com.randev.toa.feature.login.domain.usecase.ProdCredentialsLoginUseCase
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
abstract class UseCaseModule {

    @Binds
    abstract fun bindCredentialsLoginUseCase(
        credentialsLoginUseCase: ProdCredentialsLoginUseCase
    ): CredentialsLoginUseCase
}
