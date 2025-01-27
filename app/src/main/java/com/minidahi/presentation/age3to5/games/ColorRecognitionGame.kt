package com.minidahi.presentation.age3to5.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ColorRecognitionGame @Inject constructor() : IGame {
    private var currentLevel = 1
    private var score = 0
    private val maxLevel = 5
    
    private val _gameState = MutableLiveData<GameState>()
    val gameState: LiveData<GameState> = _gameState
    
    private val colors = listOf(
        "red",
        "blue",
        "green",
        "yellow",
        "purple"
    )
    
    private var currentColor: String = ""
    private var options: List<String> = emptyList()
    
    data class GameState(
        val targetColor: String,
        val options: List<String>,
        val level: Int,
        val score: Int
    )
    
    override fun startGame() {
        currentLevel = 1
        score = 0
        generateNewRound()
    }
    
    override fun checkAnswer(answer: Any): Boolean {
        if (answer !is String) return false
        
        val isCorrect = answer == currentColor
        if (isCorrect) {
            score += 10
            if (currentLevel < maxLevel) {
                currentLevel++
                generateNewRound()
            }
        }
        return isCorrect
    }
    
    override fun getScore() = score
    
    override fun isGameComplete() = currentLevel >= maxLevel
    
    override fun getCurrentLevel() = currentLevel
    
    private fun generateNewRound() {
        currentColor = colors.random()
        options = colors.shuffled().take(3).toMutableList().apply {
            if (!contains(currentColor)) {
                set(0, currentColor)
                shuffle()
            }
        }
        
        _gameState.value = GameState(
            targetColor = currentColor,
            options = options,
            level = currentLevel,
            score = score
        )
    }
}
