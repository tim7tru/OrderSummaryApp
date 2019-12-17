package com.timmytruong.shopifychallenge2018.util.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import kotlinx.android.synthetic.main.province_order_header.view.*
import kotlinx.android.synthetic.main.province_order_item.view.*
import java.util.*

class ProvinceViewHolder(itemView: View,
                         private val provinceOrderCount: SortedMap<String, Int>): RecyclerView.ViewHolder(itemView)
{
    fun setDetails(item: ProvinceOrderItem, viewType: Int)
    {
        when (viewType)
        {
            AppConstants.HEADER_VIEW_TYPE ->
            {
                itemView.province_header.visibility = View.VISIBLE

                itemView.province_header.province_order_header_title.text = item.shipping_address!!.province

                itemView.province_header.province_order_header_count.text = CommonUtils.formatOrderCount(provinceOrderCount[item.shipping_address!!.province].toString())
            }
            AppConstants.ITEM_VIEW_TYPE ->
            {
                itemView.province_header.visibility = View.GONE
            }
        }

        itemView.province_order_title.text = CommonUtils.formatOrderNumber(item.number.toString())

        itemView.province_order_date.text = item.processed_at

        itemView.province_order_financial_status.text = item.financial_status

        itemView.province_order_price.text = CommonUtils.formatOrderCost(item.total_price)
    }
}