package com.example.mode_goviya.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mode_goviya.data.entities.District
import com.example.mode_goviya.data.entities.Variety
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DistrictViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: LocationRepository

    init {
        val db = AppDatabase.getDatabase(application)
        repo = LocationRepository(db)
    }

    // all districts as StateFlow for Compose consumption
    val districts: StateFlow<List<District>> =
        repo.districtsFlow()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // selected district id (null = none)
    private val _selectedDistrictId = MutableStateFlow<Int?>(null)
    val selectedDistrictId: StateFlow<Int?> = _selectedDistrictId.asStateFlow()

    // varieties for current selected district as StateFlow
    val varieties: StateFlow<List<Variety>> =
        _selectedDistrictId.flatMapLatest { id ->
            if (id == null) flowOf(emptyList()) else repo.varietiesFlow(id)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun selectDistrict(id: Int?) {
        _selectedDistrictId.value = id
    }

    // helper: select by name (useful if you have only name)
    fun selectDistrictByName(name: String) {
        viewModelScope.launch {
            val dList = repo.districtsFlow().first()
            val found = dList.firstOrNull { it.name == name }
            selectDistrict(found?.id)
        }
    }
}
