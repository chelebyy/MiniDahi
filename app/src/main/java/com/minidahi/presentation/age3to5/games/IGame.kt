package com.minidahi.presentation.age3to5.games

interface IGame {
    fun startGame()
    fun checkAnswer(answer: Any): Boolean
    fun getScore(): Int
    fun isGameComplete(): Boolean
    fun getCurrentLevel(): Int
}
