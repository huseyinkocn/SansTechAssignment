package com.sanstech.sanstechtask.data.model

import com.google.gson.annotations.SerializedName

data class ScoreServiceModel(
    @SerializedName("i")
    val matchUniqueId: Int?,
    @SerializedName("sgi")
    val uniqueEventId: Int?,
    @SerializedName("d")
    val matchDate: Long?,
    @SerializedName("st")
    val sportType: String?,
    @SerializedName("bri")
    val matchReportUniqueId: Int?,
    @SerializedName("ht")
    val host: TeamInfoModel?,
    @SerializedName("at")
    val awayTeam: TeamInfoModel?,
    @SerializedName("sc")
    val score: ScoreModel?,
    @SerializedName("to")
    val tournamentInfo: TournamentInfo?,
)
