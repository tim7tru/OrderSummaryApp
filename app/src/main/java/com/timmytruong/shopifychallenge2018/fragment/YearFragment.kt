package com.timmytruong.shopifychallenge2018.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.adapter.YearAdapter
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.fragment_year.*

class YearFragment(private val orderViewModel: OrderViewModel,
                   private val itemClickedListener: ItemClickedListener): Fragment()
{
    private lateinit var yearAdapter: YearAdapter

    private val yearObserver: Observer<ArrayList<OrderItem>> = Observer {
        orderViewModel.setYearOrders(it)

        yearAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_year, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        orderViewModel.getYearResponse().observe(this, yearObserver)

        yearAdapter = YearAdapter(activity!!, orderViewModel.getYearOrders(), orderViewModel.getYearOrderCount(), itemClickedListener)

        year_recycler.layoutManager = LinearLayoutManager(activity!!)

        year_recycler.adapter = yearAdapter
    }


}