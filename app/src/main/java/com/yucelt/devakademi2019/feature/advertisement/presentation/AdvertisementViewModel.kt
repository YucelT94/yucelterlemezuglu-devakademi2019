package com.yucelt.devakademi2019.feature.advertisement.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yucelt.devakademi2019.component.advertisementitem.AdvertisementItemViewData
import com.yucelt.devakademi2019.feature.advertisement.domain.iteractor.AdvertisementUseCase
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class AdvertisementViewModel
@Inject constructor(private val useCase: AdvertisementUseCase) : ViewModel() {
    private val TAG = AdvertisementViewModel::class.java.simpleName

    val adapterLiveData = MutableLiveData<List<AdvertisementItemViewData>>()

    fun generataAdapterData(offset: Int, size: Int) {
        val params = AdvertisementUseCase.Params(offset, size)
        useCase.execute(
            params = params,
            onSuccess = {
                adapterLiveData.postValue(it.map { item -> item.toAdvertisementItemViewData() })
            },
            onError = {
                it.localizedMessage
            }
        )
    }
}