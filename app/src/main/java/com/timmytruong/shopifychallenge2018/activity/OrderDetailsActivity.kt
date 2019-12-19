package com.timmytruong.shopifychallenge2018.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.timmytruong.shopifychallenge2018.R
import com.timmytruong.shopifychallenge2018.adapter.DetailsAdapter
import com.timmytruong.shopifychallenge2018.model.OrderItem
import com.timmytruong.shopifychallenge2018.util.AppConstants
import kotlinx.android.synthetic.main.activity_order_details.*
import com.timmytruong.shopifychallenge2018.util.CommonUtils

class OrderDetailsActivity: AppCompatActivity()
{

    private lateinit var detailsAdapter: DetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_details)

        val item = intent.extras?.get(AppConstants.ITEM_INTENT_KEY) as OrderItem

        setupUI(item)

        setupAdapter(item)
    }

    private fun setupAdapter(item: OrderItem)
    {
        detailsAdapter = DetailsAdapter(
            context = this,
            lineItems = item.line_items
        )

        line_recycler.layoutManager = LinearLayoutManager(this)

        line_recycler.adapter = detailsAdapter
    }

    private fun setupUI(item: OrderItem)
    {
        details_title.text = CommonUtils.formatOrderNumber(item.number.toString())

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

        details_country.text = item.shipping_address!!.country_code

        total_price.text = String.format(resources.getString(R.string.details_total), String.format(resources.getString(R.string.general_price_format_no_currency), item.total_price))

        total_price_usd.text = String.format(resources.getString(R.string.details_total_usd), String.format(resources.getString(R.string.general_price_format_no_currency), item.total_price_usd))
    }
}
