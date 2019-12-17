package com.timmytruong.shopifychallenge2018.model

data class ProvinceOrderItem(var number: Int,
                             var processed_at: String,
                             var financial_status: String,
                             var total_price: String,
                             var total_price_usd: String,
                             var line_items: ArrayList<LineItem>,
                             var shipping_address: ShippingAddress? = ShippingAddress())
{
    fun getProvince(): String
    {
        if (shipping_address == null)
        {
            shipping_address = ShippingAddress()
        }

        return shipping_address!!.province
    }

}