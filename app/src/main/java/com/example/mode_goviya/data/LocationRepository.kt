package com.example.mode_goviya.data

import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.flow.Flow

class LocationRepository(private val db: AppDatabase) {
    fun districtsFlow(): Flow<List<District>> = db.districtDao().getAll()
    fun varietiesFlow(districtId: Int): Flow<List<Variety>> = db.varietyDao().getByDistrict(districtId)

    suspend fun insertDistrict(d: District) = db.districtDao().insert(d)
    suspend fun insertVariety(v: Variety) = db.varietyDao().insert(v)
}
