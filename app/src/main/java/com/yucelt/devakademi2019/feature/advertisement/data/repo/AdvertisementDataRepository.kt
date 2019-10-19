package com.yucelt.devakademi2019.feature.advertisement.data.repo

import com.yucelt.devakademi2019.base.room.AppDatabase
import com.yucelt.devakademi2019.feature.advertisement.data.AdvertisementApiService
import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import com.yucelt.devakademi2019.feature.advertisement.domain.AdvertisementRepository
import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementDataRepository(
    private val database: AppDatabase,
    private val service: AdvertisementApiService
) : AdvertisementRepository {

    override fun getAdvertisementList(offset: Int, size: Int): Single<List<AdvertisementResponse>> =
        service.getAdvertisementList(offset, size)
}