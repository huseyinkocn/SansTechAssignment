package com.sanstech.sanstechtask.utils.cache

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject

class PrefUtil @Inject constructor(context: Context, var gson: Gson) {

    private val CUSTOMER_SESSION = ""
    private val SPLASHSCREEN = ""

    private fun getBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        val pref = context.getSharedPreferences(CUSTOMER_SESSION, Context.MODE_PRIVATE)
        return pref.getBoolean(key, defValue)
    }

    private fun putBoolean(context: Context, key: String, value: Boolean?) {
        val pref = context.getSharedPreferences(CUSTOMER_SESSION, Context.MODE_PRIVATE)
        pref.edit().putBoolean(key, value!!).apply()
    }

    fun getSplashScreen(context: Context): Boolean {
        return getBoolean(context, SPLASHSCREEN, false).not()
    }

    fun disableSplashScreen(context: Context) {
        putBoolean(context, SPLASHSCREEN, true)
    }
}