package edu.cnm.deepdive.graffiti.service

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ServiceModule {

    @Binds
    @Singleton
    fun bindUserService(implementation: UserServiceImpl): UserService


}