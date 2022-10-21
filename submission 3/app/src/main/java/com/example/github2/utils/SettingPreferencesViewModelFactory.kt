package com.example.github2.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github2.data.database.SettingPreferences
import com.example.github2.ui.SettingPreferencesViewModel
import java.lang.IllegalArgumentException

class SettingPreferencesViewModelFactory(
    private val settingPreferences: SettingPreferences
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingPreferencesViewModel::class.java)) {
            return SettingPreferencesViewModel(settingPreferences) as T
        }

        throw IllegalArgumentException("Unknown SettingPreferencesViewModel Class : ${modelClass.name}")
    }
}