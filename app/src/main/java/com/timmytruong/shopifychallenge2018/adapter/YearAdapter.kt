package com.timmytruong.shopifychallenge2018.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.util.ui.YearViewHolder
import java.util.*

class YearAdapter(private val context: Context,
                  private val orderItems: ArrayList<OrderItem>,
                  private val yearOrderCount: SortedMap<Int, Int>,
                  private val itemClickedListener: ItemClickedListener): RecyclerView.Adapter<YearViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearViewHolder
    {
        return YearViewHolder(LayoutInflater.from(context).inflate(R.layout.province_order_item, parent, false), yearOrderCount, itemClickedListener)
    }

    override fun getItemCount(): Int
    {
        return if (!orderItems.isNullOrEmpty())
        {
            orderItems.size
        }
        else
        {
            0
        }
    }

    override fun onBindViewHolder(holder: YearViewHolder, position: Int)
    {
        if (!orderItems.isNullOrEmpty())
        {
            val item = orderItems[position]
            holder.setDetails(item, holder.itemViewType)
        }
    }

    override fun getItemViewType(position: Int): Int
    {
        return if (getHeaderTypeArray().contains(position))
        {
            AppConstants.HEADER_VIEW_TYPE
        }
        else
        {
            AppConstants.ITEM_VIEW_TYPE
        }
    }

    private fun getHeaderTypeArray(): ArrayList<Int>
    {
        var headerElement = 0

        val headerArray: ArrayList<Int> = arrayListOf()

        headerArray.add(headerElement)

        yearOrderCount.forEach {
            headerElement += it.value

            headerArray.add(headerElement)
        }

        return headerArray
    }
}