package com.timmytruong.shopifychallenge2018.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timmytruong.shopifychallenge2018.provider.OrderProvider
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.repository.OrderRepository
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class OrderViewModel @Inject constructor(private val orderRepository: OrderRepository,
                                         private val orderProvider: OrderProvider): ViewModel()
{
    private var orderProvinceMutableLiveData: MutableLiveData<ArrayList<ProvinceOrderItem>> = MutableLiveData()

    private var orderYearMutableLiveData: MutableLiveData<ArrayList<ProvinceOrderItem>> = MutableLiveData()

    fun getOrderData()
    {
        orderRepository.getOrderResponse(orderProvinceMutableLiveData, orderYearMutableLiveData)
    }

    fun getProvinceResponse(): MutableLiveData<ArrayList<ProvinceOrderItem>>
    {
        return orderProvinceMutableLiveData
    }

    fun setProvinceOrders(array: ArrayList<ProvinceOrderItem>)
    {
        orderProvider.setProvinceOrder(array)
    }

    fun getProvinceOrders(): ArrayList<ProvinceOrderItem>
    {
        return orderProvider.getProvinceOrder()
    }

    fun getProvinceOrderCount(): SortedMap<String, Int>
    {
        return orderProvider.getProvinceOrderCount()
    }

    fun getYearResponse(): MutableLiveData<ArrayList<ProvinceOrderItem>>
    {
        return orderYearMutableLiveData
    }

    fun setYearOrders(array: ArrayList<ProvinceOrderItem>)
    {
        orderProvider.setYearOrder(array)
    }

    fun getYearOrders(): ArrayList<ProvinceOrderItem>
    {
        return orderProvider.getYearOrder()
    }

    fun getYearOrderCount(): SortedMap<Int, Int>
    {
        return orderProvider.getYearOrderCount()
    }
}