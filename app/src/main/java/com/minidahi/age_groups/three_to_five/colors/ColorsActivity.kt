package com.minidahi.age_groups.three_to_five.colors

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.minidahi.databinding.ActivityColorsBinding
import com.minidahi.age_groups.three_to_five.colors.match.MatchColorsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ColorsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityColorsBinding
    private val viewModel: ColorsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupButtons()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Renkler"
        }
    }

    private fun setupButtons() {
        binding.learnColorsCard.setOnClickListener {
            startActivity(Intent(this, LearnColorsActivity::class.java))
        }

        binding.matchColorsCard.setOnClickListener {
            startActivity(Intent(this, MatchColorsActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
