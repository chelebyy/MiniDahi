package com.minidahi.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton
import com.minidahi.R
import com.minidahi.age_groups.three_to_five.ThreeToFiveActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupCardAnimations()
    }
    
    private fun setupCardAnimations() {
        val buttonPress = AnimationUtils.loadAnimation(this, R.anim.button_press)
        val buttonRelease = AnimationUtils.loadAnimation(this, R.anim.button_release)
        
        // Setup animations for age group cards
        listOf(
            R.id.card_3_5,
            R.id.card_6_8,
            R.id.card_9_10
        ).forEach { cardId ->
            findViewById<CardView>(cardId).apply {
                setOnTouchListener { v, event ->
                    when (event.action) {
                        android.view.MotionEvent.ACTION_DOWN -> {
                            startAnimation(buttonPress)
                            true
                        }
                        android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                            startAnimation(buttonRelease)
                            when (id) {
                                R.id.card_3_5 -> startActivity(Intent(this@MainActivity, ThreeToFiveActivity::class.java))
                            }
                            performClick()
                            true
                        }
                        else -> false
                    }
                }
            }
        }
        
        // Setup animation for parent control button
        findViewById<MaterialButton>(R.id.parentControlButton).apply {
            setOnTouchListener { v, event ->
                when (event.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                        startAnimation(buttonPress)
                        true
                    }
                    android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                        startAnimation(buttonRelease)
                        performClick()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}