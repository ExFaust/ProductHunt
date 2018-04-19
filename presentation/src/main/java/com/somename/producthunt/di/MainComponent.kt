package com.somename.producthunt.di

import com.somename.producthunt.screen.activity.MainActivity
import com.somename.producthunt.screen.activity.ProductActivity

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [(MainModule::class)])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(productActivity: ProductActivity)

}
