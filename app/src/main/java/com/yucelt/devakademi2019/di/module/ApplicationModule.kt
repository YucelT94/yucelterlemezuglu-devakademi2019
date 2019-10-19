package com.yucelt.devakademi2019.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.yucelt.devakademi2019.di.builder.ViewModelFactoryBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Module(includes = [ViewModelFactoryBuilder::class])
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

}