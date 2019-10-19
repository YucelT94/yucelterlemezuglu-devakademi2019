package com.yucelt.devakademi2019.feature.advertisement.presentation

import android.annotation.SuppressLint
import androidx.databinding.ObservableInt
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
    val searchedLiveData = MutableLiveData<List<AdvertisementItemViewData>>()
    val adapterDataSize = ObservableInt()

    fun updateAdapterData(offset: Int, size: Int) {
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

    @SuppressLint("DefaultLocale")
    fun searchAdvertisement(text: String) {
        var list = adapterLiveData.value?.filter {
            (it.title?.toLowerCase()?.contains(text) ?: false) ||
                    (it.price?.toString()?.toLowerCase()?.contains(text) ?: false) ||
                    (it.city?.toLowerCase()?.contains(text) ?: false) ||
                    (it.town?.toLowerCase()?.contains(text) ?: false) ||
                    (it.category0?.toLowerCase()?.contains(text) ?: false)
        }

        list = list?.toMutableList()

        searchedLiveData.postValue(list)
    }
}