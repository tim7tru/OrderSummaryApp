package com.timmytruong.shopifychallenge2018.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.util.ui.ProvinceViewHolder
import java.util.*
import kotlin.collections.ArrayList

class ProvinceAdapter(private val context: Context,
                      private val orderItems: ArrayList<ProvinceOrderItem>,
                      private val provinceOrderCount: SortedMap<String, Int>,
                      private val itemClickedListener: ItemClickedListener): RecyclerView.Adapter<ProvinceViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder
    {
        return ProvinceViewHolder(LayoutInflater.from(context).inflate(R.layout.province_order_item, parent, false), provinceOrderCount, itemClickedListener)
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

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int)
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

        provinceOrderCount.forEach {
            headerElement += it.value

            headerArray.add(headerElement)
        }

        return headerArray
    }
}