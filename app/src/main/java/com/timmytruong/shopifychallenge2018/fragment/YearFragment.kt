package com.timmytruong.shopifychallenge2018.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.viewmodel.OrderViewModel

class YearFragment(private val orderViewModel: OrderViewModel): Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_year, container, false)
    }
}