package com.timmytruong.shopifychallenge2018.util.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.model.LineItem
import com.timmytruong.shopifychallenge2018.util.CommonUtils
import kotlinx.android.synthetic.main.details_line_item.view.*

class DetailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    fun setDetails(item: LineItem)
    {
        itemView.quantity.text = item.quantity.toString()
        itemView.description.text = item.name

        if (item.vendor.isNullOrEmpty())
        {
            itemView.vendor.visibility = View.GONE
        }
        else
        {
            itemView.vendor.text = item.vendor
        }

        itemView.price.text = CommonUtils.formatOrderCost(item.price)
    }
}