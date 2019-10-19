package com.yucelt.devakademi2019.feature.advertisement.data.response

import com.google.gson.annotations.SerializedName
import com.yucelt.devakademi2019.base.network.DevResponse
import com.yucelt.devakademi2019.component.advertisementitem.AdvertisementItemViewData

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementResponse : DevResponse() {
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("price")
    var price: Double? = null

    @SerializedName("city")
    var city: String? = null

    @SerializedName("town")
    var town: String? = null

    @SerializedName("has_promotion")
    var hasPromotion: Int? = null

    @SerializedName("view_count")
    var viewCount: Int? = null

    @SerializedName("c0")
    var c0: String? = null

    @SerializedName("c1")
    var c1: String? = null

    @SerializedName("c2")
    var c2: String? = null

    @SerializedName("c3")
    var c3: String? = null

    @SerializedName("c4")
    var c4: String? = null

    @SerializedName("c5")
    var c5: String? = null

    @SerializedName("c6")
    var c6: String? = null

    /**
     * Advertisement Model of Response
     */

    fun toAdvertisementItemViewData() = AdvertisementItemViewData(
        id = id,
        title = title,
        town = town,
        city = city,
        price = price
    )
}