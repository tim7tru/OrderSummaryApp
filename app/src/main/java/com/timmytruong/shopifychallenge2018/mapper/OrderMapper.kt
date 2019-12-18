package com.timmytruong.shopifychallenge2018.mapper

import com.timmytruong.shopifychallenge2018.model.Order
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import com.timmytruong.shopifychallenge2018.util.enums.Months
import java.time.YearMonth
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

            it.date_format = CommonUtils.formatOrderDate(day, month.toString(), year)

            it.processed_day = day.toInt()

            it.processed_month = (split[0].substring(5..6)).toInt()

            it.processed_year = year.toInt()
        }

        Collections.sort(result.orders, Comparator.comparing(ProvinceOrderItem::getProvince))

        return ArrayList(result.orders)
    }

    fun processYearResponse(result: Order): ArrayList<ProvinceOrderItem>
    {
        result.orders.forEach {
            val split = it.processed_at.split('T')

            val timeOffset: String = split[1].substring(8..13)

            val offsettedTime: String = split[1].substring(0..7)

            getUTC(it, offsettedTime, timeOffset)

        }
        val orders = ArrayList(result.orders)

        Collections.sort(orders, Comparator.comparing(ProvinceOrderItem::processed_year)
                .thenComparing(ProvinceOrderItem::processed_month)
                .thenComparing(ProvinceOrderItem::processed_day)
                .thenComparing(ProvinceOrderItem::processed_hour)
                .thenComparing(ProvinceOrderItem::processed_minute)
                .thenComparing(ProvinceOrderItem::processed_second))

        orders.reverse()

        return orders
    }

    private fun getUTC(item: ProvinceOrderItem, time: String, offset: String)
    {

        val offsetOperator = offset.substring(0)

        val offsetHour = offset.substring(1..2).toInt()

        val offsetMinute = offset.substring(4..5).toInt()

        item.processed_hour = time.substring(0..1).toInt()

        item.processed_minute = time.substring(3..4).toInt()

        item.processed_second = time.substring(6..7).toInt()

        when (offsetOperator)
        {
            "+" ->
            {
                item.processed_hour += offsetHour

                item.processed_minute += offsetMinute

                correctTime(item)
            }
            "-" ->
            {
                item.processed_hour -= offsetHour

                item.processed_minute -= offsetMinute

                correctTime(item)
            }
        }
    }

    private fun correctTime(item: ProvinceOrderItem)
    {
        if (item.processed_minute > 59)
        {
            item.processed_minute -= 60

            item.processed_hour++
        }
        else if (item.processed_minute < 0)
        {
            item.processed_minute += 60

            item.processed_hour--
        }

        if (item.processed_hour > 23)
        {
            item.processed_hour -= 24

            item.processed_day++

            correctDate(item)
        }
        else if (item.processed_hour < 0)
        {
            item.processed_hour += 24

            item.processed_day--

            correctDate(item)
        }
    }

    private fun correctDate(item: ProvinceOrderItem)
    {
        val yearMonth = YearMonth.of(item.processed_year, item.processed_month)

        if (item.processed_day > yearMonth.lengthOfMonth())
        {
            item.processed_month++

            item.processed_day -= yearMonth.lengthOfMonth()

            if (item.processed_month > 12)
            {
                item.processed_year++

                item.processed_month -= 12
            }
        }
        else if (item.processed_day < 0)
        {
            item.processed_month--

            val newYearMonth = YearMonth.of(item.processed_year, item.processed_month)

            item.processed_day += newYearMonth.lengthOfMonth()

            if (item.processed_month < 0)
            {
                item.processed_year--

                item.processed_month += 12
            }
        }
    }
}