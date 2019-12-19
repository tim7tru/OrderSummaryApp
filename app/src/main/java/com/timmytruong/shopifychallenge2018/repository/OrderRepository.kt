package com.timmytruong.shopifychallenge2018.repository

import androidx.lifecycle.MutableLiveData
import com.timmytruong.shopifychallenge2018.interfaces.OrderService
import com.timmytruong.shopifychallenge2018.mapper.OrderMapper
import com.timmytruong.shopifychallenge2018.model.Order
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class OrderRepository @Inject constructor(private val orderService: OrderService,
                                          private val orderMapper: OrderMapper)
{
    private var orderResponseCall: Call<Order>? = null

    fun getOrderResponse(orderMutableResponse: MutableLiveData<ArrayList<OrderItem>>, orderYearMutableResponse: MutableLiveData<ArrayList<OrderItem>>)
    {
        orderResponseCall = orderService.getOrders(AppConstants.API_PAGE_QUERY, AppConstants.API_TOKEN_QUERY)

        orderResponseCall!!.enqueue(
            object: Callback<Order>
            {
                override fun onResponse(call: Call<Order>, response: Response<Order>)
                {
                    if (response.isSuccessful && response.body() != null)
                    {
                        orderMutableResponse.value = orderMapper.processProvinceResponse(response.body()!!)
                        orderYearMutableResponse.value = orderMapper.processYearResponse(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<Order>, t: Throwable)
                {
                    TODO()
                }
            }
        )
    }
}