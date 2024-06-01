package com.kyryll.geotestapp.data.remote.requests

import com.google.android.gms.maps.model.LatLng
import com.google.gson.annotations.SerializedName

data class ApiPostPositionsRequest(
    @SerializedName("positions")
    val positions: List<LatLng>
)
