package com.example.github2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.github2.data.database.SettingPreferences
import kotlinx.coroutines.launch

class SettingPreferencesViewModel(
    private val settingPreferences: SettingPreferences
) : ViewModel() {

    fun themeSetting(isNightModeActive: Boolean) {
        viewModelScope.launch {
            settingPreferences.saveThemeSetting(isNightModeActive)
        }
    }

    fun themeSetting(): LiveData<Boolean> {
        return settingPreferences.getThemeSetting().asLiveData()
    }
}