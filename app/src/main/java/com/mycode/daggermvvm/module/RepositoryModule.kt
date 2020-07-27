package com.mycode.daggermvvm.module

import com.mycode.daggermvvm.repository.UserRepository
import com.mycode.daggermvvm.repository.UserRepositoryImpl
import com.mycode.mvvmkotlin.network.ApiInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: ApiInterface): UserRepository {
        return UserRepositoryImpl(api)
    }
}