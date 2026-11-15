package com.example.ahorcado.adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ahorcado.R
import com.example.ahorcado.game.Levels

/** Utilizar adapter en veces de ir creando botones repetitivas como dijistes en clase,
 esta class use un poco el apoyo de IA**/
class LevelAdapter(private val levels: List<Levels>, private val onLevelClick: (Levels) -> Unit) : RecyclerView.Adapter<LevelAdapter.LevelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int)
    {
        holder.bind(levels[position], onLevelClick)
    }

    override fun getItemCount(): Int = levels.size

    class LevelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val numberText: TextView = itemView.findViewById(R.id.item_level_number)
        private val wordText: TextView = itemView.findViewById(R.id.item_level_word)
        private val lettersText: TextView = itemView.findViewById(R.id.item_level_letters)
        private val difficultyImage: ImageView = itemView.findViewById(R.id.item_level_difficulty)


        fun bind(level: Levels, onLevelClick: (Levels) -> Unit)
        {
            Log.d("LevelSelector", "bind row ${level.number}")
            val context = itemView.context
            numberText.text = context.getString(R.string.level_number, level.number)
            wordText.text = context.getString(R.string.level_word, level.word)
            lettersText.text = context.getString(R.string.level_letters, level.letterCount)
            difficultyImage.setImageResource(level.difficulty.iconRes)
            itemView.setOnClickListener { onLevelClick(level) }
        }
    }
}