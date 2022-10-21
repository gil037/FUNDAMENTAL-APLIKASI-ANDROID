package com.example.github2.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.github2.R
import com.example.github2.data.database.SettingPreferences
import com.example.github2.databinding.ActivitySettingsBinding
import com.example.github2.utils.SettingPreferencesViewModelFactory

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            elevation = 0.4F
            title = getString(R.string.setting_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        val settingPreferences = SettingPreferences.getInstance(dataStore)
        val settingPreferencesViewModel = ViewModelProvider(
            this,
            SettingPreferencesViewModelFactory(settingPreferences)
        )[SettingPreferencesViewModel::class.java]

        settingPreferencesViewModel.themeSetting().observe(this) { isNightModeActive ->
            if (isNightModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.themeSwitch.isChecked = true
                binding.icThemeImageview.setImageResource(R.drawable.ic_night_mode)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.themeSwitch.isChecked = false
            }
        }

        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            settingPreferencesViewModel.themeSetting(isChecked)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}