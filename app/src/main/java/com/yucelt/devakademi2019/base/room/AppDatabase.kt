package com.yucelt.devakademi2019.base.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        val DB_NAME = "SahibindenChallange.db"
    }
}