package com.timmytruong.shopifychallenge2018.provider

import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import java.util.*
import javax.inject.Inject

class OrderProvider @Inject constructor()
{
    private val ordersByProvince: ArrayList<ProvinceOrderItem> = arrayListOf()

    private val provinceOrderCount: SortedMap<String, Int> = sortedMapOf()

    fun setProvinceOrder(array: ArrayList<ProvinceOrderItem>?)
    {
        if (array != null)
        {
            ordersByProvince.addAll(array)

            setProvinceOrderCount()
        }
    }

    private fun setProvinceOrderCount()
    {
        ordersByProvince.forEach {
            if (provinceOrderCount.keys.contains(it.shipping_address!!.province))
            {
                provinceOrderCount[it.shipping_address!!.province] = provinceOrderCount[it.shipping_address!!.province]!!.plus(1)
            }
            else
            {
                provinceOrderCount[it.shipping_address!!.province] = 1
            }
        }
    }

    fun getProvinceOrderCount(): SortedMap<String, Int>
    {
        return provinceOrderCount
    }

    fun getProvinceOrder(): ArrayList<ProvinceOrderItem>
    {
        return ordersByProvince
    }
}