package com.yucelt.devakademi2019.component.advertisementitem

import androidx.databinding.ObservableDouble
import androidx.databinding.ObservableField
import com.yucelt.devakademi2019.base.devcomponent.DevComponentViewModel


/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
class AdvertisementItemViewModel : DevComponentViewModel<AdvertisementItemViewData>() {

    val titleObservable = ObservableField<String>()
    val locationObservable = ObservableField<String>()
    val priceObservable = ObservableDouble()

    override fun handleInput(viewData: AdvertisementItemViewData?) {
        viewData?.run {
            titleObservable.set(title)
            locationObservable.set("$town/$city")
            price?.let { priceObservable.set(it) }
        }
    }
}