package com.sanstech.sanstechtask.data.model

import com.google.gson.annotations.SerializedName

class ScoreServiceEntity (
    @SerializedName("data")
    val data: ArrayList<ScoreServiceModel>?
) : BaseEntity()