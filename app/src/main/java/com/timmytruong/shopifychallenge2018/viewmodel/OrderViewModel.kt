package com.timmytruong.shopifychallenge2018.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timmytruong.shopifychallenge2018.provider.OrderProvider
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.repository.OrderRepository
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class OrderViewModel @Inject constructor(private val orderRepository: OrderRepository,
                                         private val orderProvider: OrderProvider): ViewModel()
{
    private var orderMutableLiveData: MutableLiveData<ArrayList<OrderItem>> = MutableLiveData()

    private var orderYearMutableLiveData: MutableLiveData<ArrayList<OrderItem>> = MutableLiveData()

    fun getOrderData()
    {
        orderRepository.getOrderResponse(orderMutableLiveData, orderYearMutableLiveData)
    }

    fun getProvinceResponse(): MutableLiveData<ArrayList<OrderItem>>
    {
        return orderMutableLiveData
    }

    fun setProvinceOrders(array: ArrayList<OrderItem>)
    {
        orderProvider.setProvinceOrder(array)
    }

    fun getProvinceOrders(): ArrayList<OrderItem>
    {
        return orderProvider.getProvinceOrder()
    }

    fun getProvinceOrderCount(): SortedMap<String, Int>
    {
        return orderProvider.getProvinceOrderCount()
    }

    fun getYearResponse(): MutableLiveData<ArrayList<OrderItem>>
    {
        return orderYearMutableLiveData
    }

    fun setYearOrders(array: ArrayList<OrderItem>)
    {
        orderProvider.setYearOrder(array)
    }

    fun getYearOrders(): ArrayList<OrderItem>
    {
        return orderProvider.getYearOrder()
    }

    fun getYearOrderCount(): SortedMap<Int, Int>
    {
        return orderProvider.getYearOrderCount()
    }
}