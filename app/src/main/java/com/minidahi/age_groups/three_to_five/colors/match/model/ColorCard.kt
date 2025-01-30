package com.minidahi.age_groups.three_to_five.colors.match.model

import androidx.annotation.ColorRes

data class ColorCard(
    @ColorRes val colorResId: Int,
    val isMatched: Boolean = false,
    val isFlipped: Boolean = false,
    val position: Int
)
