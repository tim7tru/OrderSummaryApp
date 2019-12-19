package com.timmytruong.shopifychallenge2018.util.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import kotlinx.android.synthetic.main.province_order_header.view.*
import kotlinx.android.synthetic.main.province_order_item.view.*
import java.util.*

class YearViewHolder(itemView: View,
                     private val yearOrderCount: SortedMap<Int, Int>,
                     private val itemClickedListener: ItemClickedListener): RecyclerView.ViewHolder(itemView)
{
    fun setDetails(item: OrderItem, viewType: Int)
    {
        itemView.setOnClickListener {
            itemClickedListener.openDetailsActivity(item)
        }

        when (viewType)
        {
            AppConstants.HEADER_VIEW_TYPE ->
            {
                itemView.province_header.visibility = View.VISIBLE

                itemView.province_header.province_order_header_title.text = item.processed_year.toString()

                itemView.province_header.province_order_header_count.text = CommonUtils.formatOrderCount(yearOrderCount[item.processed_year].toString())
            }
            AppConstants.ITEM_VIEW_TYPE ->
            {
                itemView.province_header.visibility = View.GONE
            }
        }

        itemView.province_order_title.text = CommonUtils.formatOrderNumber(item.number.toString())

        itemView.province_order_date.text = item.date_format

        itemView.province_order_financial_status.text = item.financial_status

        itemView.province_order_price.text = CommonUtils.formatOrderCost(item.total_price)
    }
}