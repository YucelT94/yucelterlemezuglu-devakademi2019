package com.yucelt.devakademi2019.di.module

import com.yucelt.devakademi2019.feature.advertisement.presentation.AdvertisementActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    // TODO: Activituleri ekle
    @ContributesAndroidInjector
    fun advertisementActivityInjector(): AdvertisementActivity
}