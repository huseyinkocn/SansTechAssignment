package com.sanstech.sanstechtask.utils

sealed class DataHolder<out T> {

    data class Success<T>(
        val body: T
    ) : DataHolder<T>()

    class Empty<T> : DataHolder<T>()

    data class Error<T>(val errorMessage: String) : DataHolder<T>()
}