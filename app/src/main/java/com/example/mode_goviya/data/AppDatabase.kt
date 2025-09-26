package com.example.mode_goviya.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mode_goviya.data.dao.DistrictDao
import com.example.mode_goviya.data.dao.VarietyDao
import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety

@Database(entities = [District::class, Variety::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun districtDao(): DistrictDao
    abstract fun varietyDao(): VarietyDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mode_goviya_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = inst
                inst
            }
    }
}
