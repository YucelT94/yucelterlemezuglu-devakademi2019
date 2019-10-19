package com.yucelt.devakademi2019.component.advertisementitem

import com.yucelt.devakademi2019.base.devcomponent.DevComponentEventHandler

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
interface AdvertisementItemEventHandlerl : DevComponentEventHandler {

    /**
     * Single click callback
     */
    fun onAdvertisementClick()
}