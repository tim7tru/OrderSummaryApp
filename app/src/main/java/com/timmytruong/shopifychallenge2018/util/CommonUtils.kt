package com.timmytruong.shopifychallenge2018.util

import android.content.Context
import com.timmytruong.shopifychallenge2018.R

object CommonUtils
{
    private lateinit var orderNumberFormat: String

    private lateinit var orderDateFormat: String

    private lateinit var orderCostFormat: String

    private lateinit var orderCountFormat: String

    fun loadResources(context: Context)
    {
        orderNumberFormat = context.resources.getString(R.string.province_order_item_title)

        orderDateFormat = context.resources.getString(R.string.province_order_item_date)

        orderCostFormat = context.resources.getString(R.string.general_price_format)

        orderCountFormat = context.resources.getString(R.string.province_order_header_count)
    }

    fun formatOrderNumber(number: String): String
    {
        return String.format(orderNumberFormat, number)
    }

    fun formatOrderDate(day: String, month: String, year: String): String
    {
        return String.format(orderDateFormat, day, month, year)
    }

    fun formatOrderCost(cost: String): String
    {
        return String.format(orderCostFormat, cost)
    }

    fun formatOrderCount(count: String): String
    {
        return String.format(orderCountFormat, count)
    }
}