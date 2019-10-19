package com.yucelt.devakademi2019.base.network

import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
interface ApiTask<Response : DevResponse?, Request : DevRequest?> {
    fun execute(request: Request): Single<Response>
}
