package com.kyryll.geotestapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity
data class PositionEntity(
    @PrimaryKey val id: Int? = null,
    val positions: LatLng
)