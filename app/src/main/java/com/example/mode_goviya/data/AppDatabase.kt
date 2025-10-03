package com.example.mode_goviya.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mode_goviya.data.dao.DistrictDao
import com.example.mode_goviya.data.dao.VarietyDao
import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [District::class, Variety::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun districtDao(): DistrictDao
    abstract fun varietyDao(): VarietyDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        private const val DB_NAME = "mode_goviya_db"

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // seed on create in background
                            CoroutineScope(Dispatchers.IO).launch {
                                val database = getDatabase(context) // safe: will return instance
                                DatabaseSeeder.seed(database)
                            }
                        }
                    })
                    .build()
                INSTANCE = inst
                inst
            }
        }
    }
}
