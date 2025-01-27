package com.minidahi.presentation.age3to5.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import kotlin.random.Random

class SimpleCountingGame @Inject constructor() : IGame {
    private var currentLevel = 1
    private var score = 0
    private val maxLevel = 5
    
    private val _gameState = MutableLiveData<GameState>()
    val gameState: LiveData<GameState> = _gameState
    
    private var correctCount: Int = 0
    private var options: List<Int> = emptyList()
    
    data class GameState(
        val itemCount: Int,
        val options: List<Int>,
        val level: Int,
        val score: Int
    )
    
    override fun startGame() {
        currentLevel = 1
        score = 0
        generateNewRound()
    }
    
    override fun checkAnswer(answer: Any): Boolean {
        if (answer !is Int) return false
        
        val isCorrect = answer == correctCount
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
        // Her seviye için maksimum sayı miktarı
        val maxCount = when(currentLevel) {
            1 -> 3
            2 -> 5
            3 -> 7
            4 -> 8
            else -> 10
        }
        
        correctCount = Random.nextInt(1, maxCount + 1)
        
        // Yanlış cevap seçenekleri oluştur
        val wrongOptions = mutableSetOf<Int>()
        while (wrongOptions.size < 2) {
            val wrongOption = Random.nextInt(1, maxCount + 1)
            if (wrongOption != correctCount) {
                wrongOptions.add(wrongOption)
            }
        }
        
        options = (wrongOptions + correctCount).shuffled()
        
        _gameState.value = GameState(
            itemCount = correctCount,
            options = options,
            level = currentLevel,
            score = score
        )
    }
}
