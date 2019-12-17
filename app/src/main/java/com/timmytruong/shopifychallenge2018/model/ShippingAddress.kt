package com.timmytruong.shopifychallenge2018.model

data class ShippingAddress(var first_name: String? = null,
                           var last_name: String? = null,
                           var address1: String = "Unknown",
                           var city: String = "Unknown",
                           var zip: String = "Unknown",
                           var province: String = "Unknown",
                           var country_code: String = "Unknown")