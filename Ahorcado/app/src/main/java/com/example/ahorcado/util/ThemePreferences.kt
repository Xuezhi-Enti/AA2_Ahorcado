package com.example.ahorcado.util

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

object ThemePreferences //helper class to save day night mode
{
    private const val PREFS_NAME = "hangman_prefs"
    private const val KEY_NIGHT_MODE = "night_mode"

    //apply saved mode for the app
    fun applySaved(context: Context)
    {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val mode = prefs.getInt(KEY_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        AppCompatDelegate.setDefaultNightMode(mode)
    }


    fun setNightMode(context: Context, mode: Int)
    {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().putInt(KEY_NIGHT_MODE, mode).apply()
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}