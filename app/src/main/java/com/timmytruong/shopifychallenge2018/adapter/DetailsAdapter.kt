package com.timmytruong.shopifychallenge2018.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.model.LineItem
import com.timmytruong.shopifychallenge2018.util.ui.DetailsViewHolder

class DetailsAdapter(private val context: Context,
                     private val lineItems: ArrayList<LineItem>): RecyclerView.Adapter<DetailsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder
    {
        return DetailsViewHolder(LayoutInflater.from(context).inflate(R.layout.details_line_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return lineItems.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int)
    {
        val item = lineItems[position]
        holder.setDetails(item)
    }
}