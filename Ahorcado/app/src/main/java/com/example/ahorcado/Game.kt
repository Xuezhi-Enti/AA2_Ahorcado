package com.example.ahorcado

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.ahorcado.game.HangmanGame

class Game : MainActivity()
{
    private lateinit var game: HangmanGame
    private lateinit var hangmanImage: ImageView
    private lateinit var wordText: TextView
    private lateinit var resultOverlay: TextView
    private val keyButtons = mutableMapOf<Char, Button>()


    private val hangmanStages = intArrayOf(
        R.drawable.hangman0, R.drawable.hangman1, R.drawable.hangman2,
        R.drawable.hangman3, R.drawable.hangman4, R.drawable.hangman5,
        R.drawable.hangman6
    )

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setupToolbar()

        val word = intent.getStringExtra(EXTRA_WORD).orEmpty()
        if (word.isEmpty())
        {
            finish()
            return
        }

        val savedGuesses = savedInstanceState?.getString(STATE_GUESSES).orEmpty()
        game = HangmanGame(word, savedGuesses.toList())

        hangmanImage = findViewById(R.id.game_hangman_image)
        wordText = findViewById(R.id.game_word_text)
        resultOverlay = findViewById(R.id.game_result_overlay)
        resultOverlay.setOnClickListener { finish() }

        buildKeyboard()
        refreshUi()
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_GUESSES, game.guessedAsString())
    }

    private fun buildKeyboard()
    {
        val keyboard: GridLayout = findViewById(R.id.game_keyboard)
        keyboard.columnCount = resources.getInteger(R.integer.keyboard_columns)

        for (letter in FIRST_LETTER..LAST_LETTER)
        {
            val key = layoutInflater.inflate(R.layout.item_keyboard, keyboard, false) as Button
            key.text = letter.toString()
            key.isEnabled = !game.isGuessed(letter)
            key.setOnClickListener { onLetterPressed(letter) }
            key.setOnLongClickListener { toggleCase(key); true }  // true = consume the click
            keyboard.addView(key)
            keyButtons[letter] = key
        }
    }

    private fun onLetterPressed(letter: Char)
    {
        game.guess(letter)
        keyButtons[letter]?.isEnabled = false
        refreshUi()
    }

    private fun toggleCase(key: Button)
    {
        val current = key.text.toString()
        key.text = if (current.first().isUpperCase()) current.lowercase() else current.uppercase()
    }

    private fun refreshUi()
    {
        wordText.text = game.maskedWord()
        hangmanImage.setImageResource(hangmanStages[game.errorCount.coerceAtMost(HangmanGame.MAX_ERRORS)])

        if (game.isFinished)
        {
            resultOverlay.setText(if (game.isWon) R.string.you_win else R.string.you_lose)
            resultOverlay.visibility = View.VISIBLE
        }
    }

    companion object
    {
        const val EXTRA_WORD = "extra_word"
        private const val STATE_GUESSES = "state_guesses"
        private const val FIRST_LETTER = 'A'
        private const val LAST_LETTER = 'Z'
    }
}
