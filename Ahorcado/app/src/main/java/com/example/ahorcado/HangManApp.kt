package com.example.ahorcado
import android.app.Application
import com.example.ahorcado.util.ThemePreferences

class HangManApp : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        ThemePreferences.applySaved(this)
    }
}