package com.minidahi.age_groups.three_to_five

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minidahi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThreeToFiveActivity : AppCompatActivity() {
    private val viewModel: ThreeToFiveViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_to_five)
        
        setupActivity()
    }

    private fun setupActivity() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.categoryRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        
        val categories = listOf(
            Category(1, "Renkler", R.drawable.ic_category_colors),
            Category(2, "Şekiller", R.drawable.ic_category_shapes),
            Category(3, "Sayılar", R.drawable.ic_category_numbers),
            Category(4, "Hayvanlar", R.drawable.ic_category_animals)
        )

        categoryAdapter = CategoryAdapter(categories) { category ->
            Toast.makeText(this, "${category.title} seçildi", Toast.LENGTH_SHORT).show()
        }
        
        recyclerView.adapter = categoryAdapter
    }
}
