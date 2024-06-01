package com.kyryll.geotestapp.domain.repository

import com.google.android.gms.maps.model.LatLng
import com.kyryll.geotestapp.data.local.PositionEntity

interface PositionsRepository {
    suspend fun sendPositions(positions: List<LatLng>)
    suspend fun setPosition(position: PositionEntity)
    suspend fun getRecords(): List<PositionEntity>
}