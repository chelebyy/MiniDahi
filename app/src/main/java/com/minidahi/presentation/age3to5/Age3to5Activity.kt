package com.minidahi.presentation.age3to5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.minidahi.R

@AndroidEntryPoint
class Age3to5Activity : AppCompatActivity() {
    private val viewModel: Age3to5ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age3to5)
        
        // Aktivite başlatıldığında gerekli oyun modlarını yükle
        setupGameModes()
    }

    private fun setupGameModes() {
        // Yaş grubuna özel oyun modlarını hazırla
        // 1. Şekil Eşleştirme
        // 2. Renk Tanıma
        // 3. Basit Sayı Sayma
    }
}
