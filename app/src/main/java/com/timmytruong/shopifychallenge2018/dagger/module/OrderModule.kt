package com.timmytruong.shopifychallenge2018.dagger.module

import com.timmytruong.shopifychallenge2018.provider.OrderProvider
import com.timmytruong.shopifychallenge2018.repository.OrderRepository
import com.timmytruong.shopifychallenge2018.interfaces.OrderService
import com.timmytruong.shopifychallenge2018.mapper.OrderMapper
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.viewmodel.factory.OrderViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class OrderModule
{
    @Singleton
    @Provides
    fun providesOrderService(httpClient: OkHttpClient): OrderService
    {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(AppConstants.BASE_API_URL)
            .build()
            .create(OrderService::class.java)
    }

    @Singleton
    @Provides
    fun providesOrderViewModelFactory(orderRepository: OrderRepository, orderProvider: OrderProvider): OrderViewModelFactory
    {
        return OrderViewModelFactory(orderRepository, orderProvider)
    }

    @Singleton
    @Provides
    fun providesOrderMapper(): OrderMapper
    {
        return OrderMapper()
    }

    @Singleton
    @Provides
    fun providesOrderRepository(orderService: OrderService, orderMapper: OrderMapper): OrderRepository
    {
        return OrderRepository(orderService, orderMapper)
    }

    @Singleton
    @Provides
    fun providesOrderProvider(): OrderProvider
    {
        return OrderProvider()
    }
}