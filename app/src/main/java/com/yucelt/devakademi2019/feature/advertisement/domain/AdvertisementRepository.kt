package com.yucelt.devakademi2019.feature.advertisement.domain

import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
interface AdvertisementRepository {
    /**
     * Get my orders list datas
     */
    fun getMyOrders(): Single<List<AdvertisementResponse>>
}