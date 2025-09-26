package com.example.mode_goviya.data.dao

import androidx.room.*
import com.example.mode_goviya.data.entities.District
import kotlinx.coroutines.flow.Flow

@Dao
interface DistrictDao {
    @Query("SELECT * FROM districts ORDER BY name")
    fun getAll(): Flow<List<District>>

    @Query("SELECT COUNT(*) FROM districts")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(district: District): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(districts: List<District>): List<Long>
}
