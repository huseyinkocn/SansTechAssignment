package com.sanstech.sanstechtask.utils

import androidx.annotation.MainThread

abstract class RequestHelper<T> {
    val SUCCESS: Boolean = true
    val ERROR: Int = 400

    suspend fun loadRequest(
        iNetworkResponseHandling: INetworkResponseHandling?,
        needProgressBar: Boolean,
    ): DataHolder<T> {
        if (needProgressBar) iNetworkResponseHandling?.loading(true)
        val response = createNetworkRequest()
        if (iNetworkResponseHandling != null) {
            dissmissProgressBar(needProgressBar, iNetworkResponseHandling)
        }
        return response.let {
            //TODO:bak
            DataHolder.Success(response)
        }
    }

    @MainThread
    protected abstract suspend fun createNetworkRequest(): T

    private fun dissmissProgressBar(
        isNeedProgressBar: Boolean,
        iNetworkResponseHandling: INetworkResponseHandling
    ) {
        if (isNeedProgressBar) iNetworkResponseHandling.loading(false)
    }
}
