package com.example.ahorcado.game
import androidx.annotation.DrawableRes
import com.example.ahorcado.R

enum class Difficulties(@DrawableRes val iconRes: Int)
{
    EASY(R.drawable.easy_image),
    MEDIUM(R.drawable.medium_image),
    HARD(R.drawable.hard_image),
    VERY_HARD(R.drawable.very_hard_image);

    companion object {
        private const val EASY_MAX_LETTERS = 4
        private const val MEDIUM_MAX_LETTERS = 7
        private const val HARD_MAX_LETTERS = 10

        /** Check difficulty **/
        fun fromLength(letterCount: Int): Difficulties = when
        {
            letterCount <= EASY_MAX_LETTERS -> EASY
            letterCount <= MEDIUM_MAX_LETTERS -> MEDIUM
            letterCount <= HARD_MAX_LETTERS -> HARD
            else -> VERY_HARD
        }
    }
}