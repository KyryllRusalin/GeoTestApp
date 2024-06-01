package com.kyryll.geotestapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ApiPostPositionsResponse(
    @SerializedName("message")
    val message: String
)
