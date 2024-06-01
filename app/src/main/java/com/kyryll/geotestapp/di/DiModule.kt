package com.kyryll.geotestapp.di

import android.app.Application
import androidx.room.Room
import com.kyryll.geotestapp.data.local.PositionDao
import com.kyryll.geotestapp.data.local.PositionsDatabase
import com.kyryll.geotestapp.data.remote.MockApi
import com.kyryll.geotestapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MockApi = retrofit.create(MockApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PositionsDatabase {
        return Room.databaseBuilder(
            app, PositionsDatabase::class.java, "positions_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: PositionsDatabase): PositionDao = db.dao
}
