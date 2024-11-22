package com.online.template.core.features.landing

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Dao
interface TestDao {
    @Insert(entity = TestDataClass::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveTestData(testDataClass: TestDataClass)
}

@Entity
data class TestDataClass(
    @PrimaryKey
    @ColumnInfo("ID")
    val id: Int,
    @ColumnInfo("name")
    val name: String?
)