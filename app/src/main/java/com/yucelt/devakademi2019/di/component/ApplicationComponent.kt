package com.yucelt.devakademi2019.di.component

import android.app.Application
import com.yucelt.devakademi2019.MainApplication
import com.yucelt.devakademi2019.di.module.ActivityModule
import com.yucelt.devakademi2019.di.module.ApplicationModule
import com.yucelt.devakademi2019.di.module.DatabaseModule
import com.yucelt.devakademi2019.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MainApplication)
}