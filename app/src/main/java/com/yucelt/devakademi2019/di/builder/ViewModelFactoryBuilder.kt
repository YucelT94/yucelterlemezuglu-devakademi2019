package com.yucelt.devakademi2019.di.builder

import androidx.lifecycle.ViewModelProvider
import com.yucelt.devakademi2019.di.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Module(includes = [(ViewModelsBuilder::class)])
abstract class ViewModelFactoryBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}