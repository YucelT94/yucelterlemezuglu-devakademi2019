package com.yucelt.devakademi2019.feature.advertisement.domain.iteractor

import com.yucelt.devakademi2019.base.domain.SingleUseCase
import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import com.yucelt.devakademi2019.feature.advertisement.domain.AdvertisementRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class AdvertisementUseCase @Inject constructor(private val repository: AdvertisementRepository) :
    SingleUseCase<List<AdvertisementResponse>>() {

    override fun buildUseCaseSingle(): Single<List<AdvertisementResponse>> {
        return repository.getMyOrders()
    }
}