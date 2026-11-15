package com.example.ahorcado
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashScreen: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        findViewById<View>(R.id.splash_root).setOnClickListener { openLevelSelector() }
    }

    private fun openLevelSelector()
    {
        startActivity(Intent(this, LevelSelector::class.java))
        finish()
    }
}