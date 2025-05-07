package com.example.verses

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.verses.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emotionList = listOf(
            "Sadness", "Anger", "Fear", "Anxiety", "Guilt",
            "Shame", "Loneliness", "Frustration", "Hopelessness", "Grief"
        )

        val recyclerView = binding.emotionRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = EmotionAdapter(emotionList) { selectedEmotion ->
            val intent = Intent(this, QuoteActivity::class.java)
            intent.putExtra("emotion", selectedEmotion)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}