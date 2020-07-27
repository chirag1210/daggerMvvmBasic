package com.mycode.daggermvvm.component

import com.mycode.daggermvvm.module.AppModule
import com.mycode.daggermvvm.module.RepositoryModule
import com.mycode.daggermvvm.module.ViewModelModule
import com.mycode.daggermvvm.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
}