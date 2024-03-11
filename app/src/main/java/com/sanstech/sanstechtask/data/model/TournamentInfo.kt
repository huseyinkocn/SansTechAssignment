package com.sanstech.sanstechtask.data.model

import com.google.gson.annotations.SerializedName

data class TournamentInfo(
    @SerializedName("i")
    val tournamentUniqueId: Int?,
    @SerializedName("n")
    val tournamentName: String?,
    @SerializedName("sn")
    val tournamentSortName: String?,
    @SerializedName("p")
    val tournamentPoint: Int?,
    @SerializedName("flag")
    val flag: String?,
)
