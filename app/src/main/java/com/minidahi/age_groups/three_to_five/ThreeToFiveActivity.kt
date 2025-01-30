package com.minidahi.age_groups.three_to_five

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.minidahi.R
import com.minidahi.age_groups.three_to_five.colors.ColorsActivity
import com.minidahi.databinding.ActivityThreeToFiveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThreeToFiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeToFiveBinding
    private val viewModel: ThreeToFiveViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeToFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar'ı ayarla ve geri butonunu göster
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        setupRecyclerView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupRecyclerView() {
        categoryAdapter = CategoryAdapter { category ->
            when (category.id) {
                1 -> startActivity(Intent(this, ColorsActivity::class.java))
                2 -> Toast.makeText(this, "Şekiller yakında eklenecek", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "Sayılar yakında eklenecek", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "Hayvanlar yakında eklenecek", Toast.LENGTH_SHORT).show()
            }
        }
        
        binding.categoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(this@ThreeToFiveActivity, 2)
        }

        val categories = listOf(
            Category(1, "Renkler", R.drawable.ic_category_colors),
            Category(2, "Şekiller", R.drawable.ic_category_shapes),
            Category(3, "Sayılar", R.drawable.ic_category_numbers),
            Category(4, "Hayvanlar", R.drawable.ic_category_animals)
        )
        categoryAdapter.submitList(categories)
    }
}
