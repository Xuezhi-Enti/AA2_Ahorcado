package com.example.ahorcado.game

/** Esta clase esta creado con apoyo de IA la funcion de esconder letras **/
class HangmanGame(rawWord: String, initialGuesses: Collection<Char> = emptyList())
{
    private val word: String = rawWord.uppercase()
    private val guessedLetters = mutableSetOf<Char>()

    init
    {
        initialGuesses.forEach { guessedLetters.add(it.uppercaseChar()) }
    }

    val errorCount: Int get() = guessedLetters.count { it !in word }

    val isWon: Boolean get() = word.all { it in guessedLetters }
    val isLost: Boolean get() = errorCount >= MAX_ERRORS
    val isFinished: Boolean get() = isWon || isLost

    fun guess(letter: Char): Boolean
    {

        val upperLetter = letter.uppercaseChar()
        if (!isFinished) guessedLetters.add(upperLetter)
        return upperLetter in word
    }

    fun isGuessed(letter: Char): Boolean = letter.uppercaseChar() in guessedLetters


    fun maskedWord(): String =
        word.map { if (it in guessedLetters) it else HIDDEN_CHAR }.joinToString(SEPARATOR)


    fun guessedAsString(): String = guessedLetters.joinToString("")
    companion object
    {
        const val MAX_ERRORS = 6
        private const val HIDDEN_CHAR = '_'
        private const val SEPARATOR = " "
    }

}