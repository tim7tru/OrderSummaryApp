package com.timmytruong.shopifychallenge2018.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.adapter.ProvinceAdapter
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.fragment_province.*

class ProvinceFragment(private val orderViewModel: OrderViewModel,
                       private val itemClickedListener: ItemClickedListener) : Fragment()
{
    private lateinit var provinceAdapter: ProvinceAdapter

    private val observer: Observer<ArrayList<OrderItem>> = Observer {
        orderViewModel.setProvinceOrders(it)

        provinceAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_province, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        orderViewModel.getProvinceResponse().observe(this, observer)

        provinceAdapter = ProvinceAdapter(activity!!, orderViewModel.getProvinceOrders(), orderViewModel.getProvinceOrderCount(), itemClickedListener)

        province_recycler.layoutManager = LinearLayoutManager(activity!!)

        province_recycler.adapter = provinceAdapter
    }


}
