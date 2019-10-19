package com.yucelt.devakademi2019.base.devcomponent

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
abstract class DevComponentViewModel<ViewData> {

    abstract fun handleInput(viewData: ViewData?)
}