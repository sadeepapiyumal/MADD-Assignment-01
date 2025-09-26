package com.example.mode_goviya.data.dao

import androidx.room.*
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.flow.Flow

@Dao
interface VarietyDao {
    @Query("SELECT * FROM varieties WHERE districtId = :districtId ORDER BY name")
    fun getByDistrict(districtId: Int): Flow<List<Variety>>

    @Query("SELECT COUNT(*) FROM varieties WHERE districtId = :districtId")
    suspend fun countForDistrict(districtId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(variety: Variety): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(varieties: List<Variety>): List<Long>
}
