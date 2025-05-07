package com.example.verses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmotionAdapter(
    private val emotions: List<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<EmotionAdapter.EmotionViewHolder>() {

    inner class EmotionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emotionText: TextView = itemView.findViewById(R.id.emotionText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmotionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emotion_item, parent, false)
        return EmotionViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmotionViewHolder, position: Int) {
        val emotion = emotions[position]
        holder.emotionText.text = emotion
        holder.itemView.setOnClickListener {
            onItemClick(emotion)
        }
    }

    override fun getItemCount(): Int = emotions.size
}

