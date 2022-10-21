package com.example.github2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.github2.data.database.UserFavoriteRepository

class UserFavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val userFavoriteRepository = UserFavoriteRepository(application)

    val getAllUserFavorites get() = userFavoriteRepository.getAllUserFavorite()
}