package com.example.mode_goviya.data

import android.content.Context
import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatabaseSeeder {
    // Example data - Sinhala names for districts, and sample varieties (change to your real list)
    private val districtNames = listOf(
        "කොළඹ","ගම්පහ","කළුතර","මහනුවර","මාතලේ","නුවරඑළිය",
        "ගාල්ල","මාතර","හම්බන්තොට","යාපනය","කිලිනොච්චිය",
        "මන්නාරම","වවුනියාව","මුලතිව්","මඩකලපුව","අම්පාර",
        "ත්‍රිකුණාමළය","කුරුණෑගල","පුත්තලම","අනුරාධපුර",
        "පොළොන්නරුව","බදුල්ල","මොනරාගල","රත්නපුර","කෑගල්ල"
    )

    // A minimal variety list; you can expand per district
    private val defaultVarieties = listOf("Bg 300","Bg 352","At 307","Su 9","Swarna")

    suspend fun seedIfNeeded(context: Context) = withContext(Dispatchers.IO) {
        val db = AppDatabase.getDatabase(context)
        val repo = LocationRepository(db)

        if (repo.districtCount() > 0) return@withContext // already seeded

        // insert districts and assign varieties (simple mapping: same default varieties for all)
        val createdIds = mutableListOf<Int>()
        for (name in districtNames) {
            val idLong = repo.insertDistrict(District(name = name))
            createdIds += idLong.toInt()
        }

        // Insert varieties: here we add the same variety options per district.
        val toInsert = mutableListOf<Variety>()
        for (districtId in createdIds) {
            defaultVarieties.forEach { v ->
                toInsert += Variety(districtId = districtId, name = v)
            }
        }
        repo.insertVarieties(toInsert)
    }
}
