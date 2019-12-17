package com.timmytruong.shopifychallenge2018.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.timmytruong.shopifychallenge2018.interfaces.OrderService
import com.timmytruong.shopifychallenge2018.mapper.OrderMapper
import com.timmytruong.shopifychallenge2018.model.Order
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class OrderRepository @Inject constructor(private val orderService: OrderService,
                                          private val orderMapper: OrderMapper
)
{
    private var orderResponseCall: Call<Order>? = null

    fun getOrderResponse(orderProvinceMutableResponse: MutableLiveData<ArrayList<ProvinceOrderItem>>, orderYearMutableResponse: MutableLiveData<ArrayList<ProvinceOrderItem>>)
    {
        orderResponseCall = orderService.getOrders(AppConstants.API_PAGE_QUERY, AppConstants.API_TOKEN_QUERY)

        orderResponseCall!!.enqueue(
            object: Callback<Order>
            {
                override fun onResponse(call: Call<Order>, response: Response<Order>)
                {
                    if (response.isSuccessful && response.body() != null)
                    {
                        orderProvinceMutableResponse.value = orderMapper.processProvinceResponse(response.body()!!)
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