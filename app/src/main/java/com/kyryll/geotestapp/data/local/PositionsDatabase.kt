package com.kyryll.geotestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PositionEntity::class],
    version = 1
)
abstract class PositionsDatabase: RoomDatabase() {
    abstract val dao: PositionDao
}