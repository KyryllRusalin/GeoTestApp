package com.kyryll.geotestapp.data.repository

import com.google.android.gms.maps.model.LatLng
import com.kyryll.geotestapp.data.local.PositionDao
import com.kyryll.geotestapp.data.local.PositionEntity
import com.kyryll.geotestapp.data.remote.MockApi
import com.kyryll.geotestapp.data.remote.requests.ApiPostPositionsRequest
import com.kyryll.geotestapp.domain.repository.PositionsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PositionsRepositoryImp @Inject constructor(
    private val api: MockApi,
    private val dao: PositionDao
) : PositionsRepository {
    override suspend fun sendPositions(positions: List<LatLng>) {
        api.postPositions(ApiPostPositionsRequest(positions))
    }

    override suspend fun setPosition(position: PositionEntity) {
        dao.insertPositions(position)
    }

    override suspend fun getRecords(): List<PositionEntity> {
        return dao.getPositions()
    }
}