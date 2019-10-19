package com.yucelt.devakademi2019.feature.advertisement.data

import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
interface AdvertisementApiService {
    /**
     * Get my orders list
     */
    @GET("auctions")
    fun getAdvertisementList(@Query("offset") offset: Int,
                             @Query("size") size: Int): Single<List<AdvertisementResponse>>
}
