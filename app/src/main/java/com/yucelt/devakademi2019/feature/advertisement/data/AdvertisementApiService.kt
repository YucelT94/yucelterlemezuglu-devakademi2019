package com.yucelt.devakademi2019.feature.advertisement.data

import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
interface AdvertisementApiService {
    /**
     * Get my orders list
     */
    @GET("auction")
    fun getAdvertisementList(): Single<List<AdvertisementResponse>>
}
