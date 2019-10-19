package com.yucelt.devakademi2019.di.module

import android.app.Application
import androidx.room.Room
import com.yucelt.devakademi2019.base.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    // TODO: Databaseleri ekle
    //  @Provides
    //  internal fun provideUserDao(appDatabase: AppDatabase): UserDao {
    //      return appDa//tabase.userDao
    //  }
}