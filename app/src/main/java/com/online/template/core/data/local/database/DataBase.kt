package com.online.template.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.online.template.features.TestDao
import com.online.template.features.TestDataClass

@Database(entities = [TestDataClass::class], version = 1000, exportSchema = false)
@TypeConverters()
abstract class DataBase : RoomDatabase() {
    abstract fun testDao(): TestDao
}