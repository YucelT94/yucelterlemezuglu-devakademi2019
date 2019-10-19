package com.yucelt.devakademi2019

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.yucelt.devakademi2019.di.component.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
class MainApplication : Application(), HasActivityInjector {

    companion object {
        private val TAG = MainApplication::class.java.simpleName
        var instance: MainApplication by Delegates.notNull()
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = activityInjector


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}