package com.somename.producthunt

import android.app.Application

import com.somename.producthunt.di.MainComponent
import com.somename.producthunt.di.MainModule
import com.somename.producthunt.di.DaggerMainComponent

class AppDelegate : Application() {

    var mainComponent: MainComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder().mainModule(MainModule(this)).build()

    }

}
