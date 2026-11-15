package com.example.ahorcado.game

data class Levels(val number: Int, val word: String)
{
    val letterCount: Int get() = word.length
    val difficulty: Difficulties get() = Difficulties.fromLength(letterCount)
}
