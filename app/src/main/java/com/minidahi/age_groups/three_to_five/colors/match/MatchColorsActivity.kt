package com.minidahi.age_groups.three_to_five.colors.match

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.minidahi.R
import com.minidahi.databinding.ActivityMatchColorsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchColorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchColorsBinding
    private val viewModel: MatchColorsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_colors)
        binding.lifecycleOwner = this

        setupToolbar()
        setupColorOptions()
        observeViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.match_colors)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupColorOptions() {
        binding.colorOption1.setOnClickListener { viewModel.onColorSelected(viewModel.colorOptions.value?.get(0) ?: return@setOnClickListener) }
        binding.colorOption2.setOnClickListener { viewModel.onColorSelected(viewModel.colorOptions.value?.get(1) ?: return@setOnClickListener) }
        binding.colorOption3.setOnClickListener { viewModel.onColorSelected(viewModel.colorOptions.value?.get(2) ?: return@setOnClickListener) }
        binding.colorOption4.setOnClickListener { viewModel.onColorSelected(viewModel.colorOptions.value?.get(3) ?: return@setOnClickListener) }
    }

    private fun observeViewModel() {
        viewModel.score.observe(this) { score ->
            binding.scoreText.text = getString(R.string.score_format, score)
        }

        viewModel.targetColor.observe(this) { colorResId ->
            binding.targetColorView.setBackgroundColor(ContextCompat.getColor(this, colorResId))
        }

        viewModel.colorOptions.observe(this) { colors ->
            binding.colorOption1.setBackgroundColor(ContextCompat.getColor(this, colors[0]))
            binding.colorOption2.setBackgroundColor(ContextCompat.getColor(this, colors[1]))
            binding.colorOption3.setBackgroundColor(ContextCompat.getColor(this, colors[2]))
            binding.colorOption4.setBackgroundColor(ContextCompat.getColor(this, colors[3]))
        }

        viewModel.gameCompleted.observe(this) { completed ->
            if (completed) {
                showGameCompletedDialog()
            }
        }
    }

    private fun showGameCompletedDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.congratulations)
            .setMessage(getString(R.string.game_completed_message, viewModel.score.value ?: 0))
            .setPositiveButton(R.string.play_again) { _, _ ->
                viewModel.initializeGame()
            }
            .setNegativeButton(R.string.close) { _, _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }
}
