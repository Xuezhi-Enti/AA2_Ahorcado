package com.example.ahorcado.game

object LevelBuilder
{
    private val words = listOf(
        "LOL", "UB", "ENTI", "VALORANT", "PC", "DEVELOPER", "FURRO",
        "GOTY", "DINERO", "PROGRAMACION"
    )

    /** start from 1 **/
    fun getLevels(): List<Levels> = words.mapIndexed { index, word -> Levels(index + 1, word) }
}