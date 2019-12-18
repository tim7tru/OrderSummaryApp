package com.timmytruong.shopifychallenge2018.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.activity.OrderDetailsActivity
import com.timmytruong.shopifychallenge2018.adapter.ProvinceAdapter
import com.timmytruong.shopifychallenge2018.interfaces.ItemClickedListener
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.fragment_province.*
import java.io.Serializable

class ProvinceFragment(private val orderViewModel: OrderViewModel,
                       private val itemClickedListener: ItemClickedListener) : Fragment()
{
    private lateinit var provinceAdapter: ProvinceAdapter

    private val provinceObserver: Observer<ArrayList<ProvinceOrderItem>> = Observer {
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

        orderViewModel.getProvinceResponse().observe(this, provinceObserver)

        provinceAdapter = ProvinceAdapter(activity!!, orderViewModel.getProvinceOrders(), orderViewModel.getProvinceOrderCount(), itemClickedListener)

        province_recycler.layoutManager = LinearLayoutManager(activity!!)

        province_recycler.adapter = provinceAdapter
    }


}
