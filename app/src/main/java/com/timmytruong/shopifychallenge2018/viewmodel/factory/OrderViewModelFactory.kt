package com.timmytruong.shopifychallenge2018.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timmytruong.shopifychallenge2018.provider.OrderProvider
import com.timmytruong.shopifychallenge2018.repository.OrderRepository
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel

class OrderViewModelFactory(private val orderRepository: OrderRepository,
                            private val orderProvider: OrderProvider
): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return OrderViewModel(
            orderRepository,
            orderProvider) as T
    }

}