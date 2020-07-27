package com.mycode.daggermvvm

import android.app.Application
import com.mycode.daggermvvm.component.AppComponent
import com.mycode.daggermvvm.component.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .build()
    }
}

lateinit var component: AppComponent