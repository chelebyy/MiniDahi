package com.minidahi.age_groups.three_to_five.colors

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minidahi.databinding.ItemColorBinding

class ColorAdapter : ListAdapter<ColorItem, ColorAdapter.ColorViewHolder>(ColorDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val binding = ItemColorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ColorViewHolder(
        private val binding: ItemColorBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(color: ColorItem) {
            binding.apply {
                colorName.text = color.name
                colorCard.setCardBackgroundColor(Color.parseColor(color.hexCode))
            }
        }
    }

    private class ColorDiffCallback : DiffUtil.ItemCallback<ColorItem>() {
        override fun areItemsTheSame(oldItem: ColorItem, newItem: ColorItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ColorItem, newItem: ColorItem): Boolean {
            return oldItem == newItem
        }
    }
}
