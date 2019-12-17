package com.timmytruong.shopifychallenge2018.interfaces

import com.timmytruong.shopifychallenge2018.model.Order
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderService
{
    @GET("admin/orders.json")
    fun getOrders(@Query("page") page: String,
                  @Query("access_token") accessToken: String): Call<Order>
}