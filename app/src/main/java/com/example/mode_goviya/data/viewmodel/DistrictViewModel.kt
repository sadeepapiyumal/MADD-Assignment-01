package com.example.mode_goviya.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mode_goviya.data.AppDatabase
import com.example.mode_goviya.data.LocationRepository
import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted

class DistrictViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = LocationRepository(AppDatabase.getDatabase(application))

    // districts as StateFlow
    val districts = repo.districtsFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedDistrictId = MutableStateFlow<Int?>(null)
    val selectedDistrictId: StateFlow<Int?> = _selectedDistrictId

    val varieties = _selectedDistrictId.flatMapLatest { id ->
        if (id == null) kotlinx.coroutines.flow.flowOf(emptyList()) else repo.varietiesFlow(id)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun selectDistrict(id: Int?) {
        _selectedDistrictId.value = id
    }

    suspend fun addDistrict(name: String) = repo.insertDistrict(District(name = name))
    suspend fun addVariety(
        districtId: Int,
        name: String,
        harvestAmount: Double = 0.0,
        periodMonths: Int = 0,
        color: String = "",
        diseaseResistance: String = ""
    ) = repo.insertVariety(
        Variety(
            districtId = districtId,
            name = name,
            harvestAmount = harvestAmount,
            periodMonths = periodMonths,
            color = color,
            diseaseResistance = diseaseResistance
        )
    )
}
