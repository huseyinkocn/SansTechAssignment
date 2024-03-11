package com.sanstech.sanstechtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseEntity(
    @Ignore
    @ColumnInfo(name = "success")
    @SerializedName("success")
    var success: Boolean? = null
) : Serializable
