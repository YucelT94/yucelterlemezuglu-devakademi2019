package com.yucelt.devakademi2019.feature.advertisement.domain

import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
interface AdvertisementRepository {
    /**
     * Get my orders list datas
     */
    fun getAdvertisementList(offset: Int, size: Int): Single<List<AdvertisementResponse>>
}