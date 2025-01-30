package com.minidahi.age_groups.three_to_five.colors

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ColorsViewModel @Inject constructor() : ViewModel() {
    // Temel renkler
    val basicColors = listOf(
        ColorItem("Kırmızı", "#FF0000"),
        ColorItem("Mavi", "#0000FF"),
        ColorItem("Sarı", "#FFEB3B"),
        ColorItem("Yeşil", "#4CAF50")
    )

    // Tüm renkler
    val allColors = listOf(
        // Ana renkler
        ColorItem("Kırmızı", "#FF0000"),
        ColorItem("Mavi", "#0000FF"),
        ColorItem("Sarı", "#FFEB3B"),
        
        // Ara renkler
        ColorItem("Yeşil", "#4CAF50"),
        ColorItem("Turuncu", "#FF9800"),
        ColorItem("Mor", "#9C27B0"),
        
        // Açık renkler
        ColorItem("Pembe", "#E91E63"),
        ColorItem("Açık Mavi", "#03A9F4"),
        ColorItem("Açık Yeşil", "#8BC34A"),
        
        // Koyu renkler
        ColorItem("Kahverengi", "#795548"),
        ColorItem("Lacivert", "#1A237E"),
        ColorItem("Bordo", "#880E4F"),
        
        // Nötr renkler
        ColorItem("Beyaz", "#FFFFFF"),
        ColorItem("Siyah", "#000000"),
        ColorItem("Gri", "#9E9E9E")
    )

    // Renk eşleştirme oyunu için renkli nesneler
    val coloredObjects = listOf(
        ColoredObject("Elma", "Kırmızı"),
        ColoredObject("Gökyüzü", "Mavi"),
        ColoredObject("Muz", "Sarı"),
        ColoredObject("Ağaç", "Yeşil")
    )
}

data class ColorItem(
    val name: String,
    val hexCode: String
)

data class ColoredObject(
    val name: String,
    val color: String
)
