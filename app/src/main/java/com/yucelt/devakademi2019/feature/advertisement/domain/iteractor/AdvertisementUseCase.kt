package com.yucelt.devakademi2019.feature.advertisement.domain.iteractor

import com.yucelt.devakademi2019.base.domain.SingleUseCase
import com.yucelt.devakademi2019.feature.advertisement.data.response.AdvertisementResponse
import com.yucelt.devakademi2019.feature.advertisement.domain.AdvertisementRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementUseCase @Inject constructor(private val repository: AdvertisementRepository) :
    SingleUseCase<List<AdvertisementResponse>, AdvertisementUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<List<AdvertisementResponse>> {
        return repository.getAdvertisementList(params.offset, params.size)
    }

    /**
     * UI'dan user input'u ile gönderilen request parametreleri.
     */
    data class Params(val offset: Int, val size: Int)
}