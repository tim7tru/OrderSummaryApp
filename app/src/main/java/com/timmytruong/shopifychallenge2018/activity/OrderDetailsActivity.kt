package com.timmytruong.shopifychallenge2018.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.model.ProvinceOrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import kotlinx.android.synthetic.main.activity_order_details.*

class OrderDetailsActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val item = intent.extras?.get(AppConstants.ITEM_INTENT_KEY) as ProvinceOrderItem

        setupUI(item)
    }

    private fun setupUI(item: ProvinceOrderItem)
    {
        details_id.text = item.id.toString()
        details_firstname.text = item.shipping_address!!.first_name!!
        details_lastname.text = item.shipping_address!!.last_name!!
        details_address.text = item.shipping_address!!.address1
        details_city.text = item.shipping_address!!.city
        details_email.text = item.email
        details_phone.text = item.shipping_address!!.phone
        details_financialstatus.text = item.financial_status
        details_processedon.text = item.date_format
        details_province.text = item.shipping_address!!.province
        details_province.text = item.shipping_address!!.country_code
    }
}
