package com.timmytruong.shopifychallenge2018.provider

import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class OrderProvider @Inject constructor()
{
    private val ordersByProvince: ArrayList<ProvinceOrderItem> = arrayListOf()

    private val ordersByYear: ArrayList<ProvinceOrderItem> = arrayListOf()

    private val provinceOrderCount: SortedMap<String, Int> = sortedMapOf()

    private val yearOrderCount: TreeMap<Int, Int> = TreeMap(Collections.reverseOrder())
    fun setProvinceOrder(array: ArrayList<ProvinceOrderItem>)
    {
        ordersByProvince.addAll(array)

        setProvinceOrderCount()
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

    fun setYearOrder(array: ArrayList<ProvinceOrderItem>)
    {
        ordersByYear.addAll(array)

        setYearCount()
    }

    private fun setYearCount()
    {
        ordersByYear.forEach {
            if (yearOrderCount.keys.contains(it.processed_year))
            {
                yearOrderCount[it.processed_year] = yearOrderCount[it.processed_year]!!.plus(1)
            }
            else
            {
                yearOrderCount[it.processed_year] = 1
            }
        }
    }

    fun getYearOrder(): ArrayList<ProvinceOrderItem>
    {
        return ordersByYear
    }

    fun getYearOrderCount(): SortedMap<Int, Int>
    {
        return yearOrderCount
    }
}