package com.minidahi.age_groups.three_to_five.colors

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.minidahi.databinding.ActivityLearnColorsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class LearnColorsActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityLearnColorsBinding
    private val viewModel: ColorsViewModel by viewModels()
    private lateinit var colorPagerAdapter: ColorPagerAdapter
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnColorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupViewPager()
        initTTS()
        setupButtons()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "Renkleri Öğrenelim"
        }
    }

    private fun setupViewPager() {
        colorPagerAdapter = ColorPagerAdapter()
        binding.viewPager.apply {
            adapter = colorPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        colorPagerAdapter.submitList(viewModel.allColors)
    }

    private fun setupButtons() {
        binding.apply {
            previousButton.setOnClickListener {
                if (viewPager.currentItem > 0) {
                    viewPager.currentItem = viewPager.currentItem - 1
                }
            }

            nextButton.setOnClickListener {
                if (viewPager.currentItem < colorPagerAdapter.itemCount - 1) {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }

            speakButton.setOnClickListener {
                val currentColor = viewModel.allColors[viewPager.currentItem]
                tts.speak(currentColor.name, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.previousButton.visibility = if (position > 0) View.VISIBLE else View.INVISIBLE
                binding.nextButton.visibility = if (position < colorPagerAdapter.itemCount - 1) View.VISIBLE else View.INVISIBLE
            }
        })
    }

    private fun initTTS() {
        tts = TextToSpeech(this, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("tr")
        }
    }

    override fun onDestroy() {
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
