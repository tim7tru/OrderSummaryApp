package com.timmytruong.shopifychallenge2018.interfaces

import com.timmytruong.shopifychallenge2018.model.OrderItem

interface ItemClickedListener
{
    fun openDetailsActivity(item: OrderItem)
}