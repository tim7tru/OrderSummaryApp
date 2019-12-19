package com.timmytruong.shopifychallenge2018.model

import java.io.Serializable

data class LineItem(var name: String = "",
                    var vendor: String = "",
                    var price: String = "",
                    var quantity: Int = -1): Serializable