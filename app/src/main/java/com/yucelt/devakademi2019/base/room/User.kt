package com.yucelt.devakademi2019.base.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by YucelTerlemezoglu on 19.10.2019.
 */
@Entity(tableName = "User")
data class User(
    @PrimaryKey var id: Long,
    var name: String,
    var password: String,
    var rememberMe: Boolean
)