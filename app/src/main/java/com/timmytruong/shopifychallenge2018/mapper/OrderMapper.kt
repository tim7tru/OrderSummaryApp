package com.timmytruong.shopifychallenge2018.mapper

import com.timmytruong.shopifychallenge2018.model.Order
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import com.timmytruong.shopifychallenge2018.util.enums.Months
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class OrderMapper
{
    fun processProvinceResponse(result: Order): ArrayList<ProvinceOrderItem>
    {
        result.orders.forEach {
            val split= it.processed_at.split('T')

            val year = split[0].substring(0..3)

            val day = split[0].substring(8..9)

            val month = Months.values()[split[0].substring(5..6).toInt() - 1]

            it.processed_at = CommonUtils.formatOrderDate(day, month.toString(), year)
        }

        Collections.sort(result.orders, Comparator.comparing(ProvinceOrderItem::getProvince))

        return ArrayList(result.orders)
    }

    fun processYearResponse(result: Order): ArrayList<ProvinceOrderItem>
    {
        val orders = ArrayList(result.orders)

        Collections.sort(orders, Comparator.comparing(ProvinceOrderItem::processed_at))

        orders.reverse()

        return orders
    }
}