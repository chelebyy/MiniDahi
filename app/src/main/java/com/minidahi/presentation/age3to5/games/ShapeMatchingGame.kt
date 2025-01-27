package com.minidahi.presentation.age3to5.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ShapeMatchingGame @Inject constructor() : IGame {
    private var currentLevel = 1
    private var score = 0
    private val maxLevel = 5
    
    private val _gameState = MutableLiveData<GameState>()
    val gameState: LiveData<GameState> = _gameState
    
    private val shapes = listOf(
        "circle",
        "square",
        "triangle",
        "star",
        "heart"
    )
    
    private var currentShape: String = ""
    private var options: List<String> = emptyList()
    
    data class GameState(
        val currentShape: String,
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
        
        val isCorrect = answer == currentShape
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
        currentShape = shapes.random()
        options = shapes.shuffled().take(3).toMutableList().apply {
            if (!contains(currentShape)) {
                set(0, currentShape)
                shuffle()
            }
        }
        
        _gameState.value = GameState(
            currentShape = currentShape,
            options = options,
            level = currentLevel,
            score = score
        )
    }
}
