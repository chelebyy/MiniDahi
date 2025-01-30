package com.minidahi.age_groups.three_to_five.colors.match

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.minidahi.databinding.ActivityMatchColorsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchColorsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchColorsBinding
    private val viewModel: MatchColorsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchColorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Renkleri Eşleştir"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
