package com.yucelt.devakademi2019.di.builder

import androidx.lifecycle.ViewModel
import com.yucelt.devakademi2019.di.ViewModelKey
import com.yucelt.devakademi2019.feature.advertisement.presentation.AdvertisementViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Module
abstract class ViewModelsBuilder {
    // TODO: ActivityViewModelleri ekle
    @Binds
    @IntoMap
    @ViewModelKey(AdvertisementViewModel::class)
    abstract fun bindMyOrdersViewModel(myOrdersViewModel: AdvertisementViewModel): ViewModel
}