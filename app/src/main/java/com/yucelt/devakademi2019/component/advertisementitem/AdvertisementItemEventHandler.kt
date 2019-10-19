package com.yucelt.devakademi2019.component.advertisementitem

import com.yucelt.devakademi2019.base.devcomponent.DevComponentEventHandler

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
interface AdvertisementItemEventHandler : DevComponentEventHandler {

    /**
     * Single click callback
     */
    fun onAdvertisementClick(viewData: AdvertisementItemViewData)
}