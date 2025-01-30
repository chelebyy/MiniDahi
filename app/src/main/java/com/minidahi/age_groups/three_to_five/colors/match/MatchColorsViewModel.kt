package com.minidahi.age_groups.three_to_five.colors.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minidahi.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchColorsViewModel @Inject constructor() : ViewModel() {

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _targetColor = MutableLiveData<Int>()
    val targetColor: LiveData<Int> = _targetColor

    private val _colorOptions = MutableLiveData<List<Int>>()
    val colorOptions: LiveData<List<Int>> = _colorOptions

    private val _gameCompleted = MutableLiveData(false)
    val gameCompleted: LiveData<Boolean> = _gameCompleted

    private val colorList = listOf(
        R.color.card_purple,
        R.color.card_teal,
        R.color.card_orange,
        R.color.card_pink
    )

    private var roundCount = 0
    private val maxRounds = 10

    init {
        startNewRound()
    }

    fun initializeGame() {
        _score.value = 0
        roundCount = 0
        _gameCompleted.value = false
        startNewRound()
    }

    private fun startNewRound() {
        if (roundCount >= maxRounds) {
            _gameCompleted.value = true
            return
        }

        // Hedef rengi seç
        val targetColor = colorList.random()
        _targetColor.value = targetColor

        // Diğer renk seçeneklerini hazırla
        val options = colorList.toMutableList()
        options.remove(targetColor)
        options.shuffle()
        
        // 3 yanlış seçenek ve 1 doğru seçenek
        val finalOptions = options.take(3).toMutableList()
        finalOptions.add(targetColor)
        finalOptions.shuffle()
        
        _colorOptions.value = finalOptions
    }

    fun onColorSelected(selectedColor: Int) {
        if (selectedColor == _targetColor.value) {
            // Doğru eşleşme
            _score.value = (_score.value ?: 0) + 10
            roundCount++
            startNewRound()
        }
        // Yanlış seçimde bir şey yapma, tekrar denemesine izin ver
    }
}
