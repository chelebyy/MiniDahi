package com.minidahi.age_groups.three_to_five

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.minidahi.R

class CategoryAdapter(
    private val categories: List<Category>,
    private val onCategoryClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount() = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardView)
        private val iconView: ImageView = itemView.findViewById(R.id.categoryIcon)
        private val titleView: TextView = itemView.findViewById(R.id.categoryTitle)

        fun bind(category: Category) {
            iconView.setImageResource(category.iconResId)
            titleView.text = category.title
            cardView.setOnClickListener { onCategoryClick(category) }
        }
    }
}

data class Category(
    val id: Int,
    val title: String,
    val iconResId: Int
)
