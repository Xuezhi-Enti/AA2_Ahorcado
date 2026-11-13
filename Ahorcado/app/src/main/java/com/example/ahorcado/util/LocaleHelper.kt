package com.example.ahorcado.util
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object LocaleHelper
{
    private const val LANG_SPANISH = "es"
    private const val LANG_ENGLISH = "en"


    fun toggle(context: Context)
    {
        val current = context.resources.configuration.locales[0].language
        val next = if (current == LANG_SPANISH) LANG_ENGLISH else LANG_SPANISH
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(next))
    }
}