package com.example.mode_goviya.data

import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.flow.Flow

class LocationRepository(private val db: AppDatabase) {
    private val districtDao = db.districtDao()
    private val varietyDao = db.varietyDao()

    fun districtsFlow(): Flow<List<District>> = districtDao.getAll()
    fun varietiesFlow(districtId: Int): Flow<List<Variety>> = varietyDao.getByDistrict(districtId)

    suspend fun insertDistrict(d: District) = districtDao.insert(d)
    suspend fun insertDistricts(items: List<District>) = districtDao.insertAll(items)

    suspend fun insertVariety(v: Variety) = varietyDao.insert(v)
    suspend fun insertVarieties(items: List<Variety>) = varietyDao.insertAll(items)

    suspend fun districtCount(): Int = districtDao.count()
    suspend fun varietyCountForDistrict(id: Int): Int = varietyDao.countForDistrict(id)
}
