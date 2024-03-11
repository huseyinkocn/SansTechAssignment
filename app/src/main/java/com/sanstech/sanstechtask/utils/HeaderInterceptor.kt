package com.sanstech.sanstechtask.utils

import okhttp3.Interceptor
import okhttp3.Response


class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        var builder = chain.request().newBuilder()
        builder.addHeader("Content-Type", "application/json;charset=UTF-8")
        builder.addHeader("Accept", "application/vnd.api+json")

        return chain.proceed(builder.build())
    }
}