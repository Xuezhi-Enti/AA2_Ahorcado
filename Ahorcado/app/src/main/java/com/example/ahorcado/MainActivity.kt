package com.example.ahorcado
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ahorcado.util.LocaleHelper
import com.example.ahorcado.util.ThemePreferences

abstract class MainActivity : AppCompatActivity()
{
    protected fun setupToolbar()
    {
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId) {
            R.id.action_language -> { LocaleHelper.toggle(this); true }
            R.id.action_theme_light -> {
                ThemePreferences.setNightMode(this, AppCompatDelegate.MODE_NIGHT_NO); true
            }
            R.id.action_theme_dark -> {
                ThemePreferences.setNightMode(this, AppCompatDelegate.MODE_NIGHT_YES); true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}