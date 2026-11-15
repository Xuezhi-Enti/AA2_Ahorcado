package com.example.ahorcado

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ahorcado.adapter.LevelAdapter
import com.example.ahorcado.game.LevelBuilder
import com.example.ahorcado.game.Levels

class LevelSelector : MainActivity()
{
    private fun openGame(level : Levels)
    {
        val intent = Intent(this, Game::class.java)
        intent.putExtra(Game.EXTRA_WORD, level.word)
        startActivity(intent)
    }
    private fun setupRecycler()
    {
        val recycler: RecyclerView = findViewById(R.id.level_recycler)
        recycler.layoutManager =
            GridLayoutManager(this, resources.getInteger(R.integer.level_columns))
        recycler.adapter = LevelAdapter(LevelBuilder.getLevels(), ::openGame)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("LevelSelector", "onCreate reached")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector) //load level selector
        setupToolbar()
        setupRecycler()
        Log.d("LevelSelector", "recycler ready, items = ${LevelBuilder.getLevels().size}")
    }

}