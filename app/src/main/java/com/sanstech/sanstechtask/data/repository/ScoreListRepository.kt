package com.sanstech.sanstechtask.data.repository

import com.sanstech.sanstechtask.data.api.ApiService
import com.sanstech.sanstechtask.data.model.ScoreServiceEntity
import com.sanstech.sanstechtask.utils.DataHolder
import com.sanstech.sanstechtask.utils.INetworkResponseHandling
import com.sanstech.sanstechtask.utils.RequestHelper
import javax.inject.Inject

class ScoreListRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getScoreList(
        iNetworkResponseHandling: INetworkResponseHandling
    ): DataHolder<ScoreServiceEntity> {
        return object : RequestHelper<ScoreServiceEntity>() {
            override suspend fun createNetworkRequest(): ScoreServiceEntity {
                return return apiService.scoreList()
            } }.loadRequest(iNetworkResponseHandling, true)
    }

}
