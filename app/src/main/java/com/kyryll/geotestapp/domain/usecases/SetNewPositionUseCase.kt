package com.kyryll.geotestapp.domain.usecases

import com.google.android.gms.maps.model.LatLng
import com.kyryll.geotestapp.data.local.PositionEntity
import com.kyryll.geotestapp.domain.repository.PositionsRepository
import com.kyryll.geotestapp.utils.Constants.USER_ID
import javax.inject.Inject

class SetNewPositionUseCase @Inject constructor(
    private val repository: PositionsRepository
) {
    suspend operator fun invoke(position: LatLng) {
        val positionEntity = PositionEntity(USER_ID, position)
        repository.setPosition(positionEntity)
        if (repository.getRecords().size % 10 == 0) {
            repository.sendPositions(repository.getRecords().map { it.positions })
        }
    }
}