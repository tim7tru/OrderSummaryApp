package com.timmytruong.shopifychallenge2018.dagger.component

import com.timmytruong.shopifychallenge2018.activity.MainActivity
import com.timmytruong.shopifychallenge2018.dagger.module.HttpModule
import com.timmytruong.shopifychallenge2018.dagger.module.OrderModule
import com.timmytruong.shopifychallenge2018.fragment.ProvinceFragment
import com.timmytruong.shopifychallenge2018.fragment.YearFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HttpModule::class, OrderModule::class])
interface AppComponent
{
    fun inject(mainActivity: MainActivity)

    fun inject(provinceFragment: ProvinceFragment)

    fun inject(yearFragment: YearFragment)
}