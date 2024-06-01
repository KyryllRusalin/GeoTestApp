package com.kyryll.geotestapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PositionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPositions(positions: PositionEntity)

    @Query("SELECT COUNT(id) FROM positionentity")
    suspend fun getCount(): Int

    @Query("SELECT * FROM positionentity")
    suspend fun getPositions(): List<PositionEntity>
}