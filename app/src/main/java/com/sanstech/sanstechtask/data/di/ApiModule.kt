package com.sanstech.sanstechtask.data.di

import com.sanstech.sanstechtask.data.api.ApiService
import com.sanstech.sanstechtask.utils.Constant
import com.sanstech.sanstechtask.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(Utils.client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

}