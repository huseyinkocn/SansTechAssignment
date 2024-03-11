package com.sanstech.sanstechtask.data.model

import com.google.gson.annotations.SerializedName

data class TeamInfoModel(
    @SerializedName("i")
    val matchUniqueId: Int?,
    @SerializedName("n")
    val htName: String?,
    @SerializedName("p")
    val htPoints: Int?,
    @SerializedName("sn")
    val hostSortName: String?,
    @SerializedName("rc")
    val redCardNumber: Int?,
)
