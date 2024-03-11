package com.sanstech.sanstechtask.data.di

import android.content.Context
import com.google.gson.Gson
import com.sanstech.sanstechtask.utils.cache.PrefUtil
import com.sanstech.sanstechtask.utils.custom.CustomToast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationCache(@ApplicationContext appContext: Context): PrefUtil{
        return PrefUtil(appContext, Gson())
    }

    @Singleton
    @Provides
    fun provideCustomToast(@ApplicationContext appContext: Context): CustomToast {
        return CustomToast(appContext)
    }
}