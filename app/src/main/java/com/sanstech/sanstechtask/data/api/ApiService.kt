package com.sanstech.sanstechtask.data.api

import com.sanstech.sanstechtask.data.model.ScoreServiceEntity
import com.sanstech.sanstechtask.utils.Constant
import retrofit2.http.GET

interface ApiService {
    @GET(Constant.BASE_URL + "mobile/v2/statistics/sport/SOCCER/matches")
    suspend fun scoreList(): ScoreServiceEntity
}