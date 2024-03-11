package com.sanstech.sanstechtask.data.model

import com.google.gson.annotations.SerializedName

data class ScoreModel(
    @SerializedName("st")
    val scoreType: Int?,
    @SerializedName("abbr")
    val scoreSort: String?,
    @SerializedName("ht")
    val homeTeam: ScoreInfo?,
    @SerializedName("at")
    val awayTeam: ScoreInfo?,
)

data class ScoreInfo(
    @SerializedName("r")
    val teamScore: Int?,
    @SerializedName("c")
    val teamGoalScored: Int?,
    @SerializedName("ht")
    val firstHalf: Int?,
)
