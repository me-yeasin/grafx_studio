package com.grafxstudio.grafx_studio.di

import com.grafxstudio.grafx_studio.config.constant.Constants
import com.grafxstudio.grafx_studio.network.GrafxApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGrafxNetwork() : GrafxApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GrafxApi::class.java)
    }
}