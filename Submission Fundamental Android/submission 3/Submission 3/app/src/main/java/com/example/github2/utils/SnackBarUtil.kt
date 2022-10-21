package com.example.github2.utils

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

object SnackBarUtil {
    fun showSnackBar(view: AppCompatActivity, message: String) {
        Snackbar.make(view.window.decorView, message, Snackbar.LENGTH_SHORT).show()
    }
}