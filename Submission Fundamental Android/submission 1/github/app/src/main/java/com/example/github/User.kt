package com.example.aplikasigithubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var name: String? = null,
    var username: String? = null,
    var photo: Int? = null,
) : Parcelable