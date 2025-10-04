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
                                // store current seed version
                                val prefs = context.getSharedPreferences("db_seed", Context.MODE_PRIVATE)
                                prefs.edit().putInt("seed_version", DatabaseSeeder.SEED_VERSION).apply()
                            }
                        }
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            // if seed version changed, reseed automatically
                            CoroutineScope(Dispatchers.IO).launch {
                                val prefs = context.getSharedPreferences("db_seed", Context.MODE_PRIVATE)
                                val current = prefs.getInt("seed_version", -1)
                                if (current != DatabaseSeeder.SEED_VERSION) {
                                    val database = getDatabase(context)
                                    database.clearAllTables()
                                    DatabaseSeeder.seed(database)
                                    prefs.edit().putInt("seed_version", DatabaseSeeder.SEED_VERSION).apply()
                                }
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
