package com.online.template.core.di

import android.app.Application
import androidx.room.Room
import com.online.template.core.data.local.database.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): DataBase {
        return Room.databaseBuilder(application, DataBase::class.java, "DATABASE_NAME")
            .fallbackToDestructiveMigration()
            .build()
    }
}

