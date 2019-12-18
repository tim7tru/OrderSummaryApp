package com.timmytruong.shopifychallenge2018.interfaces

import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem

interface ItemClickedListener
{
    fun openDetailsActivity(item: ProvinceOrderItem)
}