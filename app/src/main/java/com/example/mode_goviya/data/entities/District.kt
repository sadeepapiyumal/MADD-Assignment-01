package com.example.mode_goviya.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "districts")
data class District(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
