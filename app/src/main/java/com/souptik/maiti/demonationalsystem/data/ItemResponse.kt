package com.souptik.maiti.demonationalsystem.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.souptik.maiti.demonationalsystem.data.ResponseData

data class ItemResponse(

    @Expose
    @SerializedName("ResponseCode")
    val responseCode: Int,

    @Expose
    @SerializedName("ResponseData")
    val responseList: List<ResponseData>,

    @Expose
    @SerializedName("message")
    val message: String
)