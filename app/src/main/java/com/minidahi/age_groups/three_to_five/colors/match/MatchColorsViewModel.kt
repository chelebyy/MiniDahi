package com.minidahi.age_groups.three_to_five.colors.match

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchColorsViewModel @Inject constructor() : ViewModel() {
    // Eşleştirilecek renk çiftleri
    val colorPairs = listOf(
        ColorPair("Elma", "#FF0000", "Kırmızı"),
        ColorPair("Gökyüzü", "#0000FF", "Mavi"),
        ColorPair("Muz", "#FFEB3B", "Sarı"),
        ColorPair("Çimen", "#4CAF50", "Yeşil"),
        ColorPair("Portakal", "#FF9800", "Turuncu"),
        ColorPair("Patlıcan", "#9C27B0", "Mor")
    )
}

data class ColorPair(
    val objectName: String,  // Nesnenin adı
    val colorHex: String,    // Rengin hex kodu
    val colorName: String    // Rengin adı
)
