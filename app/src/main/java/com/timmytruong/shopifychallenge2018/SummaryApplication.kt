package com.timmytruong.shopifychallenge2018

import android.app.Application
import com.timmytruong.shopifychallenge2018.dagger.component.AppComponent
import com.timmytruong.shopifychallenge2018.dagger.component.DaggerAppComponent

class SummaryApplication: Application()
{
    private lateinit var appComponent: AppComponent

    override fun onCreate()
    {
        super.onCreate()
        createAppComponent()
    }

    private fun createAppComponent()
    {
        appComponent = DaggerAppComponent.builder().build()
    }
}