package com.mycode.daggermvvm.module

import com.mycode.daggermvvm.repository.UserRepository
import com.mycode.daggermvvm.viewmodel.MainViewModelFactory
import com.mycode.mvvmkotlin.network.ApiInterface
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(userRepository: UserRepository): MainViewModelFactory {
        return MainViewModelFactory(userRepository)
    }
}