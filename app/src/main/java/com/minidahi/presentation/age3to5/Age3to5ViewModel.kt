package com.minidahi.presentation.age3to5

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Age3to5ViewModel @Inject constructor() : ViewModel() {
    // Oyun durumunu takip etmek için state
    private var currentGameMode: GameMode = GameMode.NONE
    
    // Oyun modları
    enum class GameMode {
        NONE,
        SHAPE_MATCHING,
        COLOR_RECOGNITION,
        SIMPLE_COUNTING
    }
    
    fun startGame(gameMode: GameMode) {
        currentGameMode = gameMode
        // Seçilen oyun modunu başlat
    }
}
