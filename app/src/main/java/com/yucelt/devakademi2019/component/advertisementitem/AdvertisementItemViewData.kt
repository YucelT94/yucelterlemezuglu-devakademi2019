package com.yucelt.devakademi2019.component.advertisementitem

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
data class AdvertisementItemViewData(
    val id: Long?,
    val title: String? = null,
    val town: String? = null,
    val city: String? = null,
    val price: Double? = null,
    val description: String? = null,
    val category0: String? = null,
    val viewCount: Int? = null
)