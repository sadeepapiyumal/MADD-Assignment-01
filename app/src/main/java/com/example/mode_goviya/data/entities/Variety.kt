package com.example.mode_goviya.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "varieties",
    foreignKeys = [
        ForeignKey(
            entity = District::class,
            parentColumns = ["id"],
            childColumns = ["districtId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("districtId")]
)
data class Variety(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val districtId: Int,
    val name: String
)
