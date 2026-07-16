package edu.cnm.deepdive.graffiti.service

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import jakarta.inject.Singleton

@Module
@InstallIn(ServiceComponent::class)
internal interface ServiceModule {

    @Binds
    @Singleton
    fun bindUserService(implementation: UserServiceImpl): UserService


}