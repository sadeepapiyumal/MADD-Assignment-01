package com.example.mode_goviya.data

import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety

object DatabaseSeeder {
    private val districtNames = listOf(
        "කොළඹ","ගම්පහ","කළුතර","මහනුවර","මාතලේ","නුවරඑළිය",
        "ගාල්ල","මාතර","හම්බන්තොට","යාපනය","කිලිනොච්චිය",
        "මන්නාරම","වවුනියාව","මුලතිව්","මඩකලපුව","අම්පාර",
        "ත්‍රිකුණාමළය","කුරුණෑගල","පුත්තලම","අනුරාධපුර",
        "පොළොන්නරුව","බදුල්ල","මොනරාගල","රත්නපුර","කෑගල්ල"
    )
    private val defaultVarieties = listOf("Bg 300","Bg 352","At 307","Su 9","Swarna")

    suspend fun seed(db: AppDatabase) {
        val districtDao = db.districtDao()
        val varietyDao = db.varietyDao()

        if (districtDao.count() > 0) return // already seeded

        val ids = mutableListOf<Long>()
        for (name in districtNames) {
            val id = districtDao.insert(District(name = name))
            ids.add(id)
        }

        val varietiesToInsert = mutableListOf<Variety>()
        for (districtId in ids) {
            for (v in defaultVarieties) {
                val sample = when (v) {
                    "Bg 300" -> Variety(
                        districtId = districtId.toInt(), name = v,
                        harvestAmount = 5.9, periodMonths = 3,
                        color = "සදු", diseaseResistance = "බැලෑල්ල සහිත"
                    )
                    "Bg 352" -> Variety(
                        districtId = districtId.toInt(), name = v,
                        harvestAmount = 6.0, periodMonths = 3,
                        color = "රතු", diseaseResistance = "උච්ච"
                    )
                    "At 307" -> Variety(
                        districtId = districtId.toInt(), name = v,
                        harvestAmount = 5.2, periodMonths = 3,
                        color = "කහ", diseaseResistance = "මධ්‍යම"
                    )
                    "Su 9" -> Variety(
                        districtId = districtId.toInt(), name = v,
                        harvestAmount = 5.5, periodMonths = 4,
                        color = "සුදු", diseaseResistance = "හොඳ"
                    )
                    else -> Variety(
                        districtId = districtId.toInt(), name = v,
                        harvestAmount = 5.0, periodMonths = 3,
                        color = "සුදු", diseaseResistance = "සාමාන්‍ය"
                    )
                }
                varietiesToInsert.add(sample)
            }
        }
        varietyDao.insertAll(varietiesToInsert)
    }
}
